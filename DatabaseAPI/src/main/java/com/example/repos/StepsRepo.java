package com.example.repos;

import com.example.entity.Steps;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


// Inherits CrudRepository from Sprint boot
public interface StepsRepo extends CrudRepository<Steps, UUID> {

}