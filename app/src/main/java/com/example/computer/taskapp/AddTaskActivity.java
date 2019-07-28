package com.example.computer.taskapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.computer.taskapp.fragment.DatePickerFragment;
import com.example.computer.taskapp.fragment.TimePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddTaskActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    String dueDate, dueTime;
    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Task");

        EditText task = findViewById(R.id.etTask);
        TextView categoryTextView = findViewById(R.id.category);
        CardView categoryCardView = findViewById(R.id.category_cardView);

        categoryCardView.setOnClickListener(view -> {
            popupMenu = new PopupMenu(AddTaskActivity.this, categoryCardView);
            popupMenu.getMenuInflater().inflate(R.menu.menu_category, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(AddTaskActivity.this, "Category: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                categoryTextView.setText(item.getTitle());
                return true;
            });
            popupMenu.show();
        });

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
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dueDate = format.format(calendar.getTime());
        //dueDate = dayOfMonth + "/" + month + "/" + year;
        dueDateText.setText(dueDate);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView dueTimeText = findViewById(R.id.tvDueTime);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, day, hourOfDay, minute);
        SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        dueTime = format.format(calendar.getTime());
        //dueTime = hourOfDay + ":" + minute;
        dueTimeText.setText(dueTime);
    }
}
