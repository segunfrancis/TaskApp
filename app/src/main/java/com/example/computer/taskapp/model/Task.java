package com.example.computer.taskapp.model;

public class Task {
    private int id;
    private String task;
    private String category;
    private String dueDate;
    private String dueTime;

    public Task(int id, String task, String category, String dueDate, String dueTime) {
        this.id = id;
        this.task = task;
        this.category = category;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }
}
