package com.raven.raven3hw4;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    CheckBox isDone;
    TextView dates;
    TextView dates2;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.task_title);
        isDone = itemView.findViewById(R.id.task_isDone);
        dates = itemView.findViewById(R.id.start_date);
        dates2 = itemView.findViewById(R.id.end_date);
    }
    public void onBind(Task task){
        title.setText(task.title);
        isDone.setChecked(task.isDone);
        dates.setText(task.startDateStr());
    }
    public void onBind2(Task task){
        title.setText(task.title);
        isDone.setChecked(task.isDone);
        dates.setText(task.endDateStr());
    }
}
