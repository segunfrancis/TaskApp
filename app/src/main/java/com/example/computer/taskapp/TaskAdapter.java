package com.example.computer.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.computer.taskapp.model.Task;
import com.example.computer.taskapp.util.ImageResources;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private LayoutInflater inflater;
    private Context context;

    public TaskAdapter(Context context) {
        this.context = context;
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
            switch (currentTask.getCategory()) {
                case "Personal": {
                    loadImage(context, ImageResources.personalImage, holder.moreImageView);
                    break;
                }
                case "Family": {
                    loadImage(context, ImageResources.familyImage, holder.moreImageView);
                    break;
                }
                case "Education": {
                    loadImage(context, ImageResources.educationImage, holder.moreImageView);
                    break;
                }
                case "Sports": {
                    loadImage(context, ImageResources.sportImage, holder.moreImageView);
                    break;
                }
                case "Religion": {
                    loadImage(context, ImageResources.religionImage, holder.moreImageView);
                    break;
                }
                case "Other": {
                    loadImage(context, ImageResources.otherImage, holder.moreImageView);
                    break;
                }
                case "Entertainment": {
                    loadImage(context, ImageResources.entertainmentImage, holder.moreImageView);
                    break;
                }
                default: {
                    loadImage(context, ImageResources.otherImage, holder.moreImageView);
                    break;
                }
            }

            // More Icon
            loadImage(context, ImageResources.moreIcon, holder.moreImageView);
            /*if (currentTask.getCategory().equals("Personal")) {
                //holder.categoryImage.setImageResource(R.drawable.personal_icon);
                loadImage(context, ImageResources.personalImage, holder.moreImageView);
            }*/
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void loadImage(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .into(view);
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
