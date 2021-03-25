package com.example.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Command")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true, ignoreUnknown = true)
public class Command {
    @javax.persistence.Id
    @GeneratedValue
    private UUID uuid;

    @JsonProperty(value = "system")
    private String system;

    @JsonProperty(value = "command")
    private String command;

    @JsonProperty(value = "step")
    private int stepNum;

    @JsonProperty(value = "instruction")
    @Column(columnDefinition = "LONGTEXT")
    private String instruction;

    @JsonProperty(value = "image")
    private String image;



    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStepNum() {
        return stepNum;
    }

    public void setStepNum(int stepNum) {
        this.stepNum = stepNum;
    }
}