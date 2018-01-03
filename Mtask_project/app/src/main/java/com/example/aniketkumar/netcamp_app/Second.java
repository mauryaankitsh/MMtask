package com.example.aniketkumar.netcamp_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//full Screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1=(EditText)findViewById(R.id.user);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.email);
        b1=(Button)findViewById(R.id.bsk);
        b2=(Button)findViewById(R.id.signup);
        b3=(Button)findViewById(R.id.reset);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1,s2,s3;
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fill all the filed",Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    SQLiteDatabase data = openOrCreateDatabase("net", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists camp (name varchar,password varchar,email varchar) ");
                    String s4 = "select * from camp where name ='" + s1 + "' and password ='" + s2 + "'";
                    Cursor cursor = data.rawQuery(s4, null);
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "User already Exists", Toast.LENGTH_SHORT).show();
                    } else {
                        data.execSQL("insert into camp values ('" + s1 + "','" + s2 + "','" + s3 + "') ");
                        Toast.makeText(getApplicationContext(), "Signup successfully!!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();

                    }
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
            }
        });

    }
}
