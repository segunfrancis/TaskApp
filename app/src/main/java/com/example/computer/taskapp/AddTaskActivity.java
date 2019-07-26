package com.example.computer.taskapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.computer.taskapp.fragment.DatePickerFragment;
import com.example.computer.taskapp.fragment.TimePickerFragment;

public class AddTaskActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    String dueDate, dueTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Task");

        EditText task = findViewById(R.id.etTask);
        Button createTask = findViewById(R.id.btnCreateTask);
        findViewById(R.id.imageDatePicker).setOnClickListener(dateView -> {
            DialogFragment dialogFragment = new DatePickerFragment();
            dialogFragment.show(getSupportFragmentManager(), "timePicker");
        });
        findViewById(R.id.imageTimePicker).setOnClickListener(timeView -> {
            DialogFragment dialogFragment = new TimePickerFragment();
            dialogFragment.show(getSupportFragmentManager(), "datePicker");
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        TextView dueDateText = findViewById(R.id.tvDueDate);
        dueDate = dayOfMonth + "/" + month + "/" + year;
        dueDateText.setText(dueDate);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView dueTimeText = findViewById(R.id.tvDueTime);
        dueTime = hourOfDay + ":" + minute;
        dueTimeText.setText(dueTime);
    }
}
