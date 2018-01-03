package com.example.aniketkumar.netcamp_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Q5 extends AppCompatActivity {
    static int t=0;
    RadioButton r1,r2,r3,r4;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q5);
        b1=(Button)findViewById(R.id.bqcld);
        b2=(Button)findViewById(R.id.nqcld);
        r1=(RadioButton)findViewById(R.id.radioButton17);
        r2=(RadioButton)findViewById(R.id.radioButton18);
        r3=(RadioButton)findViewById(R.id.radioButton19);
        r4=(RadioButton)findViewById(R.id.radioButton20);
        if(t==1)
        {
            (Q1.marks)++;
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Q5.this,Q4.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(r1.isChecked())
             {
                 (Q1.marks)++;
                 t++;
             }
                Intent i1=new Intent(Q5.this,Result.class);
                startActivity(i1);
                finish();

            }
        });
    }
}
