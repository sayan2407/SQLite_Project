package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    SQLiteDatabase db;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String r,n;
                    r=e1.getText().toString();
                    n=e2.getText().toString();
                    db = openOrCreateDatabase("NIIT", MODE_PRIVATE, null);
                    db.execSQL("CREATE TABLE IF NOT EXISTS t1(Roll varchar(10),Name varchar(20))");
                    db.execSQL("INSERT INTO t1 VALUES(?,?)",new Object[] { r,n});
                    db.close();
                    e1.setText("");
                    e2.setText("");
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                }catch(Exception e)
                {
                    Toast.makeText(MainActivity.this,"Error is "+e,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

