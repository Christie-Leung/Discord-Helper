package com.example.repos;

import com.example.entity.Steps;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StepsRepo extends CrudRepository<Steps, UUID> {

}