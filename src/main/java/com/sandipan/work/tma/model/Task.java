package com.sandipan.work.tma.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {

    private String taskDescription;
    private String frequency;
    private boolean reminder;

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }
}
