package com.raven.raven3hw4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    static final int KEY = 2;
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.task_list);

        adapter = new TaskAdapter();
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

//        openDetails(new Task("Some title 3",
//                "Some Discription 3", new Date(),
//                new Date(), true));
    }
        private void openDetails(Task task){
        Intent intent = new Intent(MainActivity.this, TaskDetailsActivity.class);
        intent.putExtra(TaskDetailsActivity.DETAILS_KEY, task);
        startActivity(intent);
    }

    public void add(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivityForResult(intent,KEY);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == KEY){
            if(resultCode == RESULT_OK){
                Task task = (Task) data.getSerializableExtra(Main2Activity.RESULT_KEY);
                adapter.addTask(task);

            }
        }
    }



}
