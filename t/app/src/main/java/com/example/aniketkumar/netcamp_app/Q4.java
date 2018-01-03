package com.example.aniketkumar.netcamp_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Q4 extends AppCompatActivity {
    static int s=0;
    RadioButton r1,r2,r3,r4;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        b1=(Button)findViewById(R.id.bqcld);
        b2=(Button)findViewById(R.id.nqc);
        r1=(RadioButton)findViewById(R.id.radioButton9);
        r2=(RadioButton)findViewById(R.id.radioButton10);
        r3=(RadioButton)findViewById(R.id.radioButton11);
        r4=(RadioButton)findViewById(R.id.radioButton12);
        if(s==1)
        {
            (Q1.marks)++;
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Q4.this,Q3.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r2.isChecked()){
                    (Q1.marks)++;
                    s++;}
                    Intent i1=new Intent(Q4.this,Q5.class);
                    startActivity(i1);
                    finish();


            }
        });
    }
}
