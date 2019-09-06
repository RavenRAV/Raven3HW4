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

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.task_title);
        isDone = itemView.findViewById(R.id.task_isDone);
        dates = itemView.findViewById(R.id.start_date);
    }
    public void onBind(Task task){
        title.setText(task.title);
        isDone.setChecked(task.isDone);
        dates.setText(task.dates());
    }
}
