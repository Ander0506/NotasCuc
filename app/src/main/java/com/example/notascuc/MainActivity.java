package com.example.notascuc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView LVOptions;
    private String Opc[];
    private android.content.res.Resources Resources;
    private Intent In;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LVOptions= (ListView)findViewById(R.id.LVOptions);
        Resources = this.getResources();
        Opc= Resources.getStringArray(R.array.options);

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Opc);
        LVOptions.setAdapter(Adapter);

        LVOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        In = new Intent(MainActivity.this, CreateStudent.class);
                        startActivity(In);
                        break;

                    case 1:
                        In = new Intent(MainActivity.this, ListStudents.class);
                        startActivity(In);
                        break;
                }
            }
        });
    }
}
