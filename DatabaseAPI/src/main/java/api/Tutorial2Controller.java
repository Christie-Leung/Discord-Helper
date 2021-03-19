package api;

import entity.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repos.Tutorial2Repo;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/tutorial2")
@RestController
public class Tutorial2Controller {


    private final Tutorial2Repo repo;

    @Autowired
    public Tutorial2Controller(Tutorial2Repo repo) {
        this.repo = repo;
    }

    @GetMapping("/{system}/{command}")
    public ResponseEntity<?> getInstruction(@PathVariable("system") String sys, @PathVariable("command") String para) {
        for (Command command : repo.findAll()) {
            if (command.getSystem().contains(sys) && command.getCommand().contains(para)) {
                List<String> info = new ArrayList<>();
                info.add(command.getInstruction());
                info.add(command.getImage());
                return ResponseEntity.ok(info);
            }
        }
        return ResponseEntity.badRequest().body("Error! Not Found!");
    }
}