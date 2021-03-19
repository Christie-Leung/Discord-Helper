package api;

import entity.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repos.Tutorial1Repo;

@RequestMapping("/api/tutorial1")
@RestController
public class Tutorial1Controller {


    private final Tutorial1Repo repo;

    @Autowired
    public Tutorial1Controller(Tutorial1Repo repo) {
        this.repo = repo;
    }

    @GetMapping("/{step}/{button}")
    public ResponseEntity<?> getInstruction(@PathVariable("step") int step, @PathVariable("button") String button) {
        for (Steps steps : repo.findAll()) {
            if (steps.getStep() == step && button.contains(steps.getButtonName())) {
                return ResponseEntity.ok(steps.getInstruction());
            }
        }
        return ResponseEntity.badRequest().body("Error! Not Found!");
    }
}