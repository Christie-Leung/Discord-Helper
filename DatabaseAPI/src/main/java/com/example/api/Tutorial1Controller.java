package com.example.api;

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

    /**
     * Gets the instruction according to the step number and button name
     * @param step step number
     * @param button button name
     * @return if valid, it returns the instruction
     */
    @GetMapping("/{step}/{button}")
    public ResponseEntity<?> getInstruction(@PathVariable("step") int step, @PathVariable("button") String button) {
        if (repo.count() == 0) {
            String path = System.getProperty("user.dir");
            if (convertToSteps(path)) return ResponseEntity.badRequest().build();
        }

        for (Steps steps : repo.findAll()) {
            if (steps.getStep() == step && button.toLowerCase().contains(steps.getButtonName().toLowerCase())) {
                return ResponseEntity.ok(steps.getInstruction());
            }
        }
        return ResponseEntity.badRequest().body("Error! Not Found!");
    }

    /**
     * Converts csv file data into steps that get added into the repository
     * @param path path of current running program
     * @return boolean of whether it failed to read file
     */
    private boolean convertToSteps(String path) {
        try (CSVReader reader = new CSVReader(new FileReader(path + "/resources/step.csv"))) {
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
            return true;
        }
        return false;
    }

    /**
     * In case the files need to be updated, the upload command allows them to redo the data
     * @param file file given to be uploaded/added to repo
     * @return all data that got added into repo
     */
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        String path = System.getProperty("user.dir");
        extractFile(file, path);
        if (convertToSteps(path)) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(repo.findAll());
    }

    /**
     * extracts the file provided in the upload command, copying it into the default files
     * @param file new version of file
     * @param path path of current running program
     */
    static void extractFile(@RequestParam("file") MultipartFile file, String path) {
        Path filepath = Paths.get(path + "/resources", file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}