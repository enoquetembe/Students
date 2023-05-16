package com.example.studets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private ArrayList<Student> studentList;

    private Context context;
    LayoutInflater inflater;

    public StudentAdapter( Context context, ArrayList<Student> students) {
        this.studentList = students;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_student, null);
        TextView nameTV = convertView.findViewById(R.id.tvName);
        TextView courseTV = convertView.findViewById(R.id.tvCourse);
        TextView ageTV = convertView.findViewById(R.id.tvAge);

        nameTV.setText(studentList.get(position).getName());
        courseTV.setText(studentList.get(position).getCourse());
        ageTV.setText(String.valueOf(studentList.get(position).getAge()));

        return convertView;
    }

}
