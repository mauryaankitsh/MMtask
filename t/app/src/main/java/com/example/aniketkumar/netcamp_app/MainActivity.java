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

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b3,b4;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//full Screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.user);
        e2=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.login);
        b2=(Button)findViewById(R.id.signup);
        b3=(Button)findViewById(R.id.Reset);
        b4=(Button)findViewById(R.id.forgot);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
 Intent i=new Intent(getApplicationContext(),Forgot.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Second.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill all the filed", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase data = openOrCreateDatabase("net", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists camp (name varchar,password varchar,email varchar) ");
                    String s4 = "select * from camp where name ='" + s1 + "' and password ='" + s2 + "'";
                    Cursor cursor = data.rawQuery(s4, null);
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login succesful", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),Third.class);
                        startActivity(i);
                        finish();

                    } else {
                          Toast.makeText(getApplicationContext(),"Either Username or password not correct or User not Exist",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });


    }
}
