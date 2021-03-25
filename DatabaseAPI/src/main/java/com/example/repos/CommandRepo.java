package com.example.repos;

import com.example.entity.Command;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommandRepo extends CrudRepository<Command, UUID> {

}