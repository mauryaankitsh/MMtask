package com.example.aniketkumar.netcamp_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calci extends AppCompatActivity {

    EditText e1,e2,e3;
    TextView t1;
    Button add,subs,divi,mul,reset,hi,b1;
    String s1,s2,s3=" ";
    int p=0,q=0,l=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//full Screen
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calci);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        t1=(TextView)findViewById(R.id.textView);
        add=(Button)findViewById(R.id.add);
        subs=(Button)findViewById(R.id.substract);
        divi=(Button)findViewById(R.id.division);
        mul=(Button)findViewById(R.id.multiply);
        reset=(Button)findViewById(R.id.reset);
        hi=(Button)findViewById(R.id.resethistory);
        e3=(EditText)findViewById(R.id.history);
        e3.setEnabled(false);
       b1=(Button)findViewById(R.id.back);
        Log.e("Tagg:","pass");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Third.class);
                startActivity(i);
                finish();
            }
        });

        hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e3.setText("");
                s3="";
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1=e1.getText().toString();
                s2=e2.getText().toString();

                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter all field",Toast.LENGTH_SHORT).show();
                }
                else {
                    p = 0;
                    q = 0;
                    l=0;
                    int o=0;

                    char A[] = s1.toCharArray();
                    for (int i = 0; i < s1.length(); i++) {
                        if (Character.isDigit(A[i])) {
                            p++;
                        }
                        if(A[i]=='.'&&Character.isDigit(A[i-1])&&o==0)
                        {
                            o=1;
                            p++;
                        }
                    }
                    char B[] = s2.toCharArray();
                    for (int i = 0; i < s2.length(); i++) {
                        if (Character.isDigit(B[i])) {
                            q++;
                        }
                        if(B[i]=='.'&&Character.isDigit(B[i-1])&&l==0)
                        {
                           l=1;
                            q++;
                        }
                    }
                    if ((p == s1.length() && q == s2.length())) {
                        float p, q;
                        p = Float.parseFloat(s1);
                        q = Float.parseFloat(s2);

                        float ans = p + q;
                        t1.setText("" + ans);
                        s3=s3+""+p+" + "+q+" = "+ans+"\n";
                        e3.setText(s3);

                        Toast.makeText(getApplicationContext(), "The ans is " + "" + ans, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Enter Number !!",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        Log.e("Tagg:","pass");
        subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter all field",Toast.LENGTH_SHORT).show();
                }
                else {
                    p = 0;
                    q = 0;
                    l=0;
                    int o=0;

                    char A[] = s1.toCharArray();
                    for (int i = 0; i < s1.length(); i++) {
                        if (Character.isDigit(A[i])) {
                            p++;
                        }
                        if(A[i]=='.'&&Character.isDigit(A[i-1])&&o==0)
                        {
                            o=1;
                            p++;
                        }
                    }
                    char B[] = s2.toCharArray();
                    for (int i = 0; i < s2.length(); i++) {
                        if (Character.isDigit(B[i])) {
                            q++;
                        }
                        if(B[i]=='.'&&Character.isDigit(B[i-1])&&l==0)
                        {
                            l=1;
                            q++;
                        }
                    }
                    if ((p == s1.length() && q == s2.length())) {
                        float p, q;
                        p = Float.parseFloat(s1);
                        q = Float.parseFloat(s2);

                        float ans = p - q;
                        t1.setText("" + ans);
                        s3=s3+""+p+" - "+q+" = "+ans+"\n";
                        e3.setText(s3);
                        Toast.makeText(getApplicationContext(), "The ans is " + "" + ans, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Enter Number !!",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter all field",Toast.LENGTH_SHORT).show();
                }
                else {
                    p = 0;
                    q = 0;
                    l=0;
                    int o=0;

                    char A[] = s1.toCharArray();
                    for (int i = 0; i < s1.length(); i++) {
                        if (Character.isDigit(A[i])) {
                            p++;
                        }
                        if(A[i]=='.'&&Character.isDigit(A[i-1])&&o==0)
                        {
                            o=1;
                            p++;
                        }
                    }
                    char B[] = s2.toCharArray();
                    for (int i = 0; i < s2.length(); i++) {
                        if (Character.isDigit(B[i])) {
                            q++;
                        }
                        if(B[i]=='.'&&Character.isDigit(B[i-1])&&l==0)
                        {
                            l=1;
                            q++;
                        }
                    }
                    if ((p == s1.length() && q == s2.length())) {
                        float p, q;
                        p = Float.parseFloat(s1);
                        q = Float.parseFloat(s2);

                        float ans = p * q;
                        t1.setText("" + ans);
                        s3=s3+""+p+" * "+q+" = "+ans+"\n";
                        e3.setText(s3);
                        Toast.makeText(getApplicationContext(), "The ans is " + "" + ans, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Enter Number !!",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter all field",Toast.LENGTH_SHORT).show();
                }
                else {
                    p = 0;
                    q = 0;
                    l=0;
                    int o=0;

                    char A[] = s1.toCharArray();
                    for (int i = 0; i < s1.length(); i++) {
                        if (Character.isDigit(A[i])) {
                            p++;
                        }
                        if(A[i]=='.'&&Character.isDigit(A[i-1])&&o==0)
                        {
                            o=1;
                            p++;
                        }
                    }
                    char B[] = s2.toCharArray();
                    for (int i = 0; i < s2.length(); i++) {
                        if (Character.isDigit(B[i])) {
                            q++;
                        }
                        if(B[i]=='.'&&Character.isDigit(B[i-1])&&l==0)
                        {
                            l=1;
                            q++;
                        }
                    }
                    if ((p == s1.length() && q == s2.length())) {
                        float p, q;
                        p = Float.parseFloat(s1);
                        q = Float.parseFloat(s2);

                        float ans = p / q;
                        t1.setText("" + ans);
                        s3=s3+""+p+" + "+q+" = "+ans+"\n";
                        e3.setText(s3);

                        Toast.makeText(getApplicationContext(), "The ans is " + "" + ans, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),"Enter Number !!",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        Log.e("Tagg:","pass");
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                t1.setText("");
            }
        });
    }
}
