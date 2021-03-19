package repos;

import entity.Command;
import entity.Steps;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface Tutorial2Repo extends CrudRepository<Command, Integer> {

}