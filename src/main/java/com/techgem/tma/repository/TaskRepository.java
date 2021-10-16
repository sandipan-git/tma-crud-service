package com.techgem.tma.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.techgem.tma.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class TaskRepository {

    Logger logger = LoggerFactory.getLogger(TaskRepository.class);

    @Resource(name = "dynamoDBMapper")
    DynamoDBMapper dbMapper;

    public List<Task> getAllTasks() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<Task>  listTasks = dbMapper.scan(Task.class, scanExpression);
        return listTasks;
    }

    public void addTask(Task task) {
        dbMapper.save(task);
        logger.info("Task Added : "+task.getTaskDescription());
    }

    public void deleteTask(Task task) {
        dbMapper.delete(task);
        logger.info("Task delete : "+task.getTaskDescription());
    }

}
