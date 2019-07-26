package com.example.computer.taskapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.computer.taskapp.fragment.DatePickerFragment;
import com.example.computer.taskapp.fragment.TimePickerFragment;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    String dueDate, dueTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            View view = getLayoutInflater().inflate(R.layout.add_task_layout, null);
            builder.setView(view);
            EditText task = view.findViewById(R.id.etTask);
            Button createTask = view.findViewById(R.id.btnCreateTask);
            TextView dueTimeText = view.findViewById(R.id.tvDueTime);
            TextView dueDateText = view.findViewById(R.id.tvDueDate);
            view.findViewById(R.id.imageDatePicker).setOnClickListener(dateView -> {
                DatePickerFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "timePicker");
            });
            view.findViewById(R.id.imageTimePicker).setOnClickListener(timeView -> {
                DialogFragment dialogFragment = new TimePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "datePicker");
                dialogFragment.onDismiss(new DialogInterface() {
                    @Override
                    public void cancel() {

                    }

                    @Override
                    public void dismiss() {
                        dueDateText.setText(dueDate);
                    }
                });
            });
            builder.create().show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dueDate = dayOfMonth + " " + month + " " + year;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        dueTime = hourOfDay + ":" + minute;
    }
}
