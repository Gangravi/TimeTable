package com.example.timetable;

public class FacultyModel {

    String faculty_id, faculty_name, subject_name, load_hours;

    public FacultyModel() {


    }

    public FacultyModel(String faculty_id, String faculty_name, String subject_name, String load_hours) {
        this.faculty_id = faculty_id;
        this.faculty_name = faculty_name;
        this.subject_name = subject_name;
        this.load_hours = load_hours;
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getLoad_hours() {
        return load_hours;
    }

    public void setLoad_hours(String load_hours) {
        this.load_hours = load_hours;
    }
}
