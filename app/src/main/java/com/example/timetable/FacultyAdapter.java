package com.example.timetable;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class FacultyAdapter extends ArrayAdapter<FacultyModel> {

    private Activity context;
    List<FacultyModel> faculties;


    public FacultyAdapter(Activity context, List<FacultyModel> faculties) {
        super(context, R.layout.activity_faculty_adapter, faculties);
        this.context = context;
        this.faculties = faculties;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_faculty_adapter, null, true);

        TextView textView1=listViewItem.findViewById(R.id.faculty_name1);
        TextView textView2=listViewItem.findViewById(R.id.subject_name1);
        TextView textView3=listViewItem.findViewById(R.id.load1);

        FacultyModel faculty=faculties.get(position);
        textView1.setText("Faculty Name: "+faculty.getFaculty_name());
        textView2.setText("Subject Name: "+faculty.getSubject_name());
        textView3.setText("Load Hours: "+faculty.getLoad_hours());

        return listViewItem;
    }

}
