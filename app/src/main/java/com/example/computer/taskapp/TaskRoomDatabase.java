package com.example.computer.taskapp;

import android.content.Context;

import com.example.computer.taskapp.model.Task;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskRoomDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static volatile TaskRoomDatabase INSTANCE;

    static TaskRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (TaskRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TaskRoomDatabase.class, "task_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
