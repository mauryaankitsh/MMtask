package com.example.aniketkumar.netcamp_app;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Q1 extends AppCompatActivity {
    Button b1;
    RadioButton r1,r2,r3,r4;
    static int p=0;

    static int marks=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        b1=(Button)findViewById(R.id.button16);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        if(p==1)
        {
            marks=0;
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marks=0;

                if(r2.isChecked())
                {
                    marks++;
                    p++;
                }
                Intent i=new Intent(Q1.this,Q2.class);
                startActivity(i);
                finish();
            }
        });
    }
}
