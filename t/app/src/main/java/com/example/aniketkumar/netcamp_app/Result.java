package com.example.aniketkumar.netcamp_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
     TextView t1;
    Button b1,b2,b3,b4,b5;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//full Screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1=(TextView)findViewById(R.id.textView9);
        t1.setText("The score is : "+Q1.marks);
        b1=(Button)findViewById(R.id.nc);//netcamp
        b2=(Button)findViewById(R.id.fb);//fb
        b3=(Button)findViewById(R.id.tw);//twitter
        b4=(Button)findViewById(R.id.home);//home
        b5=(Button) findViewById(R.id.logout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.netcamp.in/"));
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Intent.ACTION_VIEW);
                i1.setData(Uri.parse("https://www.facebook.com/"));
                startActivity(i1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse("https://twitter.com/"));
                startActivity(i2);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(getApplicationContext(),Third.class);
                startActivity(i3);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i4);
                finish();
            }
        });
    }
}
