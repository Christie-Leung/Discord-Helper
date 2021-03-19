package repos;

import entity.Steps;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface Tutorial1Repo extends CrudRepository<Steps, Integer> {

}