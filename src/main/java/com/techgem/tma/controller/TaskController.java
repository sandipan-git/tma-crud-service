package com.techgem.tma.controller;

import com.techgem.tma.model.Task;
import com.techgem.tma.repository.TaskRepository;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
@Api(value="taskController")
public class TaskController {

    Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskRepository taskRepository;

    @GetMapping(path = "/getAll")
    public List<Task> getAllTasks() {
        logger.info("Entering getAllTasks method");
        return taskRepository.getAllTasks();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public Task addTask(@RequestBody Task task) {
        logger.info("Entering addTask method");
        taskRepository.addTask(task);
        return task;
    }

    @PostMapping(path = "/delete", consumes = "application/json")
    public void deleteTask(@RequestBody Task task) {
        logger.info("Entering deleteTask method");
        taskRepository.deleteTask(task);
    }

}
