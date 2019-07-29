package com.example.computer.taskapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.computer.taskapp.TaskDao;
import com.example.computer.taskapp.TaskRoomDatabase;
import com.example.computer.taskapp.model.Task;

import java.util.List;

import androidx.lifecycle.LiveData;

public class TaskRepository {
    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;

    public TaskRepository(Application application) {
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    public void deleteTask(Task task) {
        new deleteAsyncTask(mTaskDao).execute(task);
    }

    public void insert(Task task) {
        new insertAsyncTask(mTaskDao).execute(task);
    }

    public void deleteAllTasks() {
        new deleteAllTasksAsyncTask(mTaskDao).execute();
    }

    public void updateTask(Task task) {
        new updateTaskAsyncTask(mTaskDao).execute(task);
    }

    public static class deleteAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDao mAsyncTaskDao;

        public deleteAsyncTask(TaskDao mAsyncTaskDao) {
            this.mAsyncTaskDao = mAsyncTaskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mAsyncTaskDao.deleteTask(tasks[0]);
            return null;
        }
    }

    public static class insertAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDao mAsyncTaskDao;

        public insertAsyncTask(TaskDao mAsyncTaskDao) {
            this.mAsyncTaskDao = mAsyncTaskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mAsyncTaskDao.insert(tasks[0]);
            return null;
        }
    }

    public static class deleteAllTasksAsyncTask extends AsyncTask<Void, Void, Void> {

        private TaskDao mAsyncTaskDao;

        public deleteAllTasksAsyncTask(TaskDao mAsyncTaskDao) {
            this.mAsyncTaskDao = mAsyncTaskDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAllTasks();
            return null;
        }
    }

    public static class updateTaskAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDao mAsyncTaskDao;

        public updateTaskAsyncTask(TaskDao mAsyncTaskDao) {
            this.mAsyncTaskDao = mAsyncTaskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            mAsyncTaskDao.updateTask(tasks[0]);
            return null;
        }
    }
}
