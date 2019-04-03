package com.example.notascuc;

import android.os.Bundle;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateStudent extends AppCompatActivity {

    private EditText Id;
    private EditText LastName;
    private EditText Name;
    private EditText Note1;
    private EditText Note2;
    private EditText Note3;
    private Resources Resources;

    private ArrayList<Student> Students = new ArrayList<Student>();

    public void SaveStuda(View view){
        String ID, NameStu, LastNameStu, Note1Stu, Note2Stu, Note3Stu;

        ID = Id.getText().toString();
        NameStu = Name.getText().toString();
        LastNameStu = LastName.getText().toString();
        Note1Stu = Note1.getText().toString();
        Note2Stu = Note2.getText().toString();
        Note3Stu = Note3.getText().toString();

        Student Stud = new Student(ID, NameStu, LastNameStu, Double.parseDouble(Note1Stu), Double.parseDouble(Note2Stu), Double.parseDouble(Note3Stu));
        Stud.SaveStudent();
        Toast.makeText(this, R.string.done , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_student);

        Id = (EditText)findViewById(R.id.TxtId);
        LastName = (EditText)findViewById(R.id.TxtLastName);
        Name = (EditText)findViewById(R.id.TxtName);
        Note1 = (EditText)findViewById(R.id.TxtNote1);
        Note2 = (EditText)findViewById(R.id.TxtNote2);
        Note3 = (EditText)findViewById(R.id.TxtNote3);

        Resources = this.getResources();
        Students = Data.GetStudents();
    }
}
