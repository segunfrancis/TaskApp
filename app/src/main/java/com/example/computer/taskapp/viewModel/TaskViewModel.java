package com.example.computer.taskapp.viewModel;

import android.app.Application;

import com.example.computer.taskapp.model.Task;
import com.example.computer.taskapp.repository.TaskRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository mRepository;
    LiveData<List<Task>> mAllTasks;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTasks();
    }

    public LiveData<List<Task>> getAllNotes() {
        return mAllTasks;
    }

    public void insert(Task task) {
        mRepository.insert(task);
    }

    public void deleteTask(Task task) {
        mRepository.deleteTask(task);
    }

    public void updateTask(Task task) {
        mRepository.updateTask(task);
    }

    public void deleteAllTasks() {
        mRepository.deleteAllTasks();
    }
}
