package com.example.api;

import com.example.entity.Command;
import com.example.repos.CommandRepo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/command")
@RestController
public class Tutorial2Controller {

    private final CommandRepo repo;

    @Autowired
    public Tutorial2Controller(CommandRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/{system}/{command}")
    public ResponseEntity<?> getInstruction(@PathVariable("system") String sys, @PathVariable("command") String para) {
        Map<Integer, String[]> info = new HashMap<>();
        for (Command command : repo.findAll()) {
            if (command.getSystem().toLowerCase().contains(sys.toLowerCase()) && command.getCommand().toLowerCase().contains(para.toLowerCase())) {
                String[] step = new String[2];
                step[0] = command.getInstruction();
                step[1] = command.getImage();
                info.put(command.getStepNum(), step);
            }
        }
        if (info.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(info.values());
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        Path filepath = Paths.get(path + "/resources", file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try (CSVReader reader = new CSVReader(new FileReader(path + "/resources/file.csv"))) {
            List<String[]> data = reader.readAll();
            for (int i = 1, dataSize = data.size(); i < dataSize; i++) {
                String[] d = data.get(i);
                Command command = new Command();
                command.setSystem(d[0]);
                command.setCommand(d[1]);
                command.setStepNum(Integer.parseInt(d[2]));
                command.setInstruction(d[3]);
                command.setImage(d[4]);
                repo.save(command);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repo.findAll());
    }
}