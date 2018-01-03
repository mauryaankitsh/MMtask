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
import android.widget.TextView;
import android.widget.Toast;

public class Forgot extends AppCompatActivity {

    Button b1,b2,b3;
    EditText e1,e2;
    TextView t1;
    String s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//full Screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        t1=(TextView)findViewById(R.id.textView);
        b1=(Button)findViewById(R.id.reset);
        b2=(Button)findViewById(R.id.submit);
        b3 = (Button) findViewById(R.id.bsk);
        e1=(EditText)findViewById(R.id.user);
        e2=(EditText)findViewById(R.id.email);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                t1.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fill all the Field",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    SQLiteDatabase data = openOrCreateDatabase("net", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists camp (name varchar,password varchar,email varchar) ");
                    String s4 = "select * from camp where name ='" + s1 + "' and email ='" + s2 + "'";
                    Cursor cursor = data.rawQuery(s4, null);
                    if (cursor.getCount() == 0) {

                        Toast.makeText(getApplicationContext(),"Username or E-mail doesnot exists",Toast.LENGTH_SHORT).show();

                    } else {
                    //  String data1=cursor.getString(cursor.getColumnIndex("password"));
                       // int i=cursor.getColumnIndex("password");

                        cursor.moveToFirst();
                        String data1=cursor.getString(1);
                        t1.setText("Your password is : "+data1);

                    }
                }

            }
        });




    }
}
