package com.example.api;

import com.example.entity.Command;
import com.example.entity.Steps;
import com.example.repos.StepsRepo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequestMapping("/api/step")
@RestController
public class Tutorial1Controller {


    private final StepsRepo repo;

    @Autowired
    public Tutorial1Controller(StepsRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/{step}/{button}")
    public ResponseEntity<?> getInstruction(@PathVariable("step") int step, @PathVariable("button") String button) {
        for (Steps steps : repo.findAll()) {
            if (steps.getStep() == step && button.toLowerCase().contains(steps.getButtonName().toLowerCase())) {
                return ResponseEntity.ok(steps.getInstruction());
            }
        }
        return ResponseEntity.badRequest().body("Error! Not Found!");
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        String path = System.getProperty("user.dir");
        extractFile(file, path);
        try (CSVReader reader = new CSVReader(new FileReader(path + "/resources/file.csv"))) {
            List<String[]> data = reader.readAll();
            for (int i = 1, dataSize = data.size(); i < dataSize; i++) {
                String[] d = data.get(i);
                Steps steps = new Steps();
                steps.setStep(Integer.parseInt(d[0]));
                steps.setButtonName(d[1]);
                steps.setInstruction(d[2]);
                repo.save(steps);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repo.findAll());
    }

    static void extractFile(@RequestParam("file") MultipartFile file, String path) {
        Path filepath = Paths.get(path + "/resources", file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}