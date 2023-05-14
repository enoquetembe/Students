package com.example.studets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private ArrayList<Student> studentList;

    public StudentAdapter(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.tvName.setText(student.getName());
        holder.tvCourse.setText(student.getCourse());
        holder.tvAge.setText(String.valueOf(student.getAge()));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCourse, tvAge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvCourse = itemView.findViewById(R.id.tvCourse);
            tvAge = itemView.findViewById(R.id.tvAge);
        }
    }
}
