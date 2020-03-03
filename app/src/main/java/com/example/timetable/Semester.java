package com.example.timetable;

public class Semester {
    String faculty_1;
    String faculty_2;
    String faculty_3;
    String faculty_4;
    String faculty_5;
    String subject_name1;
    String subject_name2;
    String subject_name3;
    String subject_name4;
    String subject_name5;

    public void setFaculty_1(String faculty_1) {
        this.faculty_1 = faculty_1;
    }

    public void setFaculty_2(String faculty_2) {
        this.faculty_2 = faculty_2;
    }

    public void setFaculty_3(String faculty_3) {
        this.faculty_3 = faculty_3;
    }

    public void setFaculty_4(String faculty_4) {
        this.faculty_4 = faculty_4;
    }

    public void setFaculty_5(String faculty_5) {
        this.faculty_5 = faculty_5;
    }

    public void setSubject_name1(String subject_name1) {
        this.subject_name1 = subject_name1;
    }

    public void setSubject_name2(String subject_name2) {
        this.subject_name2 = subject_name2;
    }

    public void setSubject_name3(String subject_name3) {
        this.subject_name3 = subject_name3;
    }

    public void setSubject_name4(String subject_name4) {
        this.subject_name4 = subject_name4;
    }

    public void setSubject_name5(String subject_name5) {
        this.subject_name5 = subject_name5;
    }

    public String getFaculty_1() {
        return faculty_1;
    }

    public String getFaculty_2() {
        return faculty_2;
    }

    public String getFaculty_3() {
        return faculty_3;
    }

    public String getFaculty_4() {
        return faculty_4;
    }

    public String getFaculty_5() {
        return faculty_5;
    }

    public String getSubject_name1() {
        return subject_name1;
    }

    public String getSubject_name2() {
        return subject_name2;
    }

    public String getSubject_name3() {
        return subject_name3;
    }

    public String getSubject_name4() {
        return subject_name4;
    }

    public String getSubject_name5() {
        return subject_name5;
    }

    public Semester(String faculty_1, String faculty_2, String faculty_3, String faculty_4, String faculty_5, String subject_name1, String subject_name2, String subject_name3, String subject_name4, String subject_name5) {
        this.faculty_1 = faculty_1;
        this.faculty_2 = faculty_2;
        this.faculty_3 = faculty_3;
        this.faculty_4 = faculty_4;
        this.faculty_5 = faculty_5;
        this.subject_name1 = subject_name1;
        this.subject_name2 = subject_name2;
        this.subject_name3 = subject_name3;
        this.subject_name4 = subject_name4;
        this.subject_name5 = subject_name5;
    }

}