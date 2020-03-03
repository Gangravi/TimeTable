package com.example.timetable;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SemesterData extends ArrayAdapter<Semester> {

    private Activity context;
    List<Semester> semester;

    public SemesterData(Activity context, List<Semester> semester) {
        super(context, R.layout.activity_semester_data, semester);
        this.context = context;
        this.semester = semester;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_semester_data, null, true);

        TextView textView1=listViewItem.findViewById(R.id.semester);
        TextView textView2=listViewItem.findViewById(R.id.faculty);
        TextView textView3=listViewItem.findViewById(R.id.faculty_name1);
        TextView textView4=listViewItem.findViewById(R.id.subject_name1);
        TextView textView5=listViewItem.findViewById(R.id.textView5);
        TextView textView6=listViewItem.findViewById(R.id.textView6);
        TextView textView7=listViewItem.findViewById(R.id.textView7);
        TextView textView8=listViewItem.findViewById(R.id.textView8);
        TextView textView9=listViewItem.findViewById(R.id.textView9);
        TextView textView10=listViewItem.findViewById(R.id.textView10);
        TextView textView11=listViewItem.findViewById(R.id.textView11);
        TextView textView12=listViewItem.findViewById(R.id.textView12);

        Semester sem = semester.get(position);
        textView3.setText(sem.getFaculty_1());
        textView5.setText(sem.getFaculty_2());
        textView7.setText(sem.getFaculty_3());
        textView9.setText(sem.getFaculty_4());
        textView11.setText(sem.getFaculty_5());
        textView4.setText(sem.getSubject_name1());
        textView6.setText(sem.getSubject_name2());
        textView8.setText(sem.getSubject_name3());
        textView10.setText(sem.getSubject_name4());
        textView12.setText(sem.getSubject_name5());

        return listViewItem;
    }
}
