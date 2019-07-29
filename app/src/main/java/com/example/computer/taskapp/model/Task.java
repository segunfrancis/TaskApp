package com.example.computer.taskapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task implements Parcelable {

    @PrimaryKey(autoGenerate = true)
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

    @Ignore
    public Task(String task, String category, String dueDate, String dueTime) {
        this.task = task;
        this.category = category;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        task = in.readString();
        category = in.readString();
        dueDate = in.readString();
        dueTime = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(task);
        dest.writeString(category);
        dest.writeString(dueDate);
        dest.writeString(dueTime);
    }
}
