package com.example.computer.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.computer.taskapp.model.Task;
import com.example.computer.taskapp.util.ImageResources;
import com.example.computer.taskapp.viewModel.TaskViewModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import androidx.annotation.NonNull;

import android.widget.PopupMenu;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private LayoutInflater inflater;
    private Context context;
    private TaskViewModel mViewModel;

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
            // More Icon
            // loadImage(context, ImageResources.moreIcon, holder.moreImageView);
            switch (currentTask.getCategory()) {
                case "Personal": {
                    loadImage(context, ImageResources.personalImage, holder.categoryImageView);
                    break;
                }
                case "Family": {
                    loadImage(context, ImageResources.familyImage, holder.categoryImageView);
                    break;
                }
                case "Education": {
                    loadImage(context, ImageResources.educationImage, holder.categoryImageView);
                    break;
                }
                case "Sports": {
                    loadImage(context, ImageResources.sportImage, holder.categoryImageView);
                    break;
                }
                case "Religion": {
                    loadImage(context, ImageResources.religionImage, holder.categoryImageView);
                    break;
                }
                case "Other": {
                    loadImage(context, ImageResources.otherImage, holder.categoryImageView);
                    break;
                }
                case "Entertainment": {
                    loadImage(context, ImageResources.entertainmentImage, holder.categoryImageView);
                    break;
                }
                default: {
                    loadImage(context, ImageResources.otherImage, holder.categoryImageView);
                    break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if (tasks != null) {
            return tasks.size();
        } else {
            return 0;
        }
    }

    private void loadImage(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .into(view);
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView taskTextView;
        private RoundedImageView categoryImageView;
        private ImageView moreImageView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            mViewModel = ViewModelProviders.of((FragmentActivity) itemView.getContext()).get(TaskViewModel.class);
            taskTextView = itemView.findViewById(R.id.tvTask);
            categoryImageView = itemView.findViewById(R.id.category_image);
            moreImageView = itemView.findViewById(R.id.more_icon);

            moreImageView.setOnClickListener(view -> {
                PopupMenu menu = new PopupMenu(context.getApplicationContext(), moreImageView);
                menu.getMenuInflater().inflate(R.menu.menu_more, menu.getMenu());

                menu.setOnMenuItemClickListener(item -> {
                    switch ((int) getItemId()) {
                        case R.id.edit_task:
                            editTask();
                            break;
                        case R.id.delete_task:
                            deleteTask();
                            break;
                        default:
                            break;
                    }
                    return true;
                });
                menu.show();
            });

            itemView.setOnClickListener(view -> {

            });
        }

        private void editTask() {

        }

        private void deleteTask() {
            Task task = getTaskAtPosition(getAdapterPosition());
            mViewModel.deleteTask(task);
        }
    }

    public Task getTaskAtPosition(int position) {
        return tasks.get(position);
    }
}
