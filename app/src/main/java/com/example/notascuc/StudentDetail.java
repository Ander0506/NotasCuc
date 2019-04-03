package com.example.notascuc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentDetail extends AppCompatActivity {

    private Intent In;
    private ArrayList<Student> Students;

    private TextView Id;
    private TextView Name;
    private TextView LastName;
    private TextView Note1;
    private TextView Note2;
    private TextView Note3;
    private TextView NoteFinal;

    private int Position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_detail);

        In = getIntent();
        Position = In.getIntExtra("position",0);

        Students = Data.GetStudents();

        Id = (TextView)findViewById(R.id.TxtId);
        Name = (TextView)findViewById(R.id.TxtName);
        LastName = (TextView)findViewById(R.id.TxtLastName);
        Note1 = (TextView)findViewById(R.id.TxtNote1);
        Note2 = (TextView)findViewById(R.id.TxtNote2);
        Note3 = (TextView)findViewById(R.id.TxtNote3);
        NoteFinal = (TextView)findViewById(R.id.TxtAverage);

        Student Stud = Students.get(Position);

        Id.setText(Stud.getId());
        Name.setText(Stud.getNombre());
        LastName.setText(Stud.getApellido());
        Note1.setText(Stud.getNota1()+"");
        Note2.setText(Stud.getNota2()+"");
        Note3.setText(Stud.getNota3()+"");
        NoteFinal.setText(Stud.getNotaProm()+"");
    }
}
