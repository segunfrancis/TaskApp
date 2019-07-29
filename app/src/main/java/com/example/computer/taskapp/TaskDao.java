package com.example.computer.taskapp;

import com.example.computer.taskapp.model.Task;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TaskDao {

    @Insert
    void insert(Task task);

    @Query("SELECT * from task_table ORDER BY id DESC")
    LiveData<List<Task>> getAllTasks();

    @Delete
    void deleteTask(Task task);

    @Query("DELETE from task_table")
    void deleteAllTasks();

    @Update
    void updateTask(Task tasks);
}
