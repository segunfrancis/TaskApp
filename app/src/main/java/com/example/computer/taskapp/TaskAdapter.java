package com.example.computer.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.computer.taskapp.model.Task;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private LayoutInflater inflater;

    public TaskAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.task_layout, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        if (tasks != null) {
            Task currentTask = tasks.get(position);
            holder.taskTextView.setText(currentTask.getTask());
            if (currentTask.getCategory().equals("Personal")) {
                holder.categoryImage.setImageResource(R.drawable.personal_icon);
            }
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView taskTextView;
        private RoundedImageView categoryImage;
        private ImageView moreImageView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTextView = itemView.findViewById(R.id.tvTask);
            categoryImage = itemView.findViewById(R.id.category_image);
            moreImageView = itemView.findViewById(R.id.more_icon);
        }
    }
}
