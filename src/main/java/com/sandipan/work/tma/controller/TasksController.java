package com.sandipan.work.tma.controller;

import com.sandipan.work.tma.model.Task;
import com.sandipan.work.tma.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tasks")
public class TasksController {

    Logger logger = LoggerFactory.getLogger(TasksController.class);

    @Autowired
    TaskRepository taskRepository;

    @PostMapping(path = "/add", consumes = "application/json")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        logger.info("Entering addTask method");
        try {
            return new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Failed to add task", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
