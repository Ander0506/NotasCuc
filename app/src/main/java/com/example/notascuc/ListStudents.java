package com.example.notascuc;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListStudents extends AppCompatActivity {
    private ListView LVStudents;
    private Resources Resources;
    private Intent In;
    private ArrayList<Student> Students;
    private ArrayList<String> StudentString;
    private TextView NoResults;
    private Student Stud;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_students);

        Students= new ArrayList<Student>();

        LVStudents = (ListView)findViewById(R.id.LVStudents);
        Resources = this.getResources();
        NoResults= (TextView)findViewById(R.id.TxtNoResults);
        NoResults.setVisibility(View.VISIBLE);
        Students=Data.GetStudents();
        StudentString = new ArrayList<String>();
        LVStudents.setVisibility(View.INVISIBLE);

        if (Students.size() > 0){
            NoResults.setVisibility(View.INVISIBLE);
            LVStudents.setVisibility(View.VISIBLE);
            for (int i = 0; i < Students.size(); i++) {
                Stud= Students.get(i);
                StudentString.add(Stud.getNombre()+" "+Stud.getApellido());
            }

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, StudentString);
        LVStudents.setAdapter(adapter);

        LVStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                In = new Intent(ListStudents.this, StudentDetail.class);
                In.putExtra("position",position);
                startActivity(In);
            }
        });
    }
}
