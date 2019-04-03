package com.example.notascuc;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Data extends AppCompatActivity {

    private static ArrayList<Student> Students = new ArrayList<Student>();

    public static void Save(Student Stud){
        Students.add(Stud);
    }

    public  static ArrayList<Student> GetStudents(){
        return Students;
    }
}
