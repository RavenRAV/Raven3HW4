package com.raven.raven3hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class TaskDetailsActivity extends AppCompatActivity {

    static final String DETAILS_KEY = "details_key";

    TextView title;
    TextView description;
    TextView startDate;
    TextView endDate;
    CheckBox isDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        setupView();
        Task task = getTask();
        showTask(task);
    }
    private void setupView(){
        title = findViewById(R.id.details_title);
        description = findViewById(R.id.details_description);
        startDate = findViewById(R.id.details_startDate);
        endDate = findViewById(R.id.details_endDate);
        isDone = findViewById(R.id.details_isDone);
    }
    private Task getTask(){//распаковка
        Intent intent = getIntent();
        Task task = (Task) intent.getSerializableExtra(DETAILS_KEY);
        return task;
    }

    private void showTask(Task task){
        title.setText(task.title);
        description.setText(task.description);
        startDate.setText(task.startDateStr());
        endDate.setText(task.endDateStr());
        isDone.setChecked(task.isDone);
    }



}


