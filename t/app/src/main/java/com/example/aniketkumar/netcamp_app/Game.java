package com.example.aniketkumar.netcamp_app;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Game extends AppCompatActivity {
    int[] hash=new int[96];
    String[] arr={"assume",
            "at",
            "attack",
            "attention",
            "attorney",
            "audience",
            "author",
            "authority",
            "available",
            "avoid",
            "away",
            "baby",
            "back",
            "bad",
            "bag",
            "ball",
            "bank",
            "bar",
            "base",
            "be",
            "beat",
            "beautiful",
            "because",
            "become",
            "bed",
            "before",
            "begin",
            "behavior",
            "behind",
            "believe",
            "benefit",
            "best",
            "better",
            "between",
            "beyond",
            "big",
            "bill",
            "billion",
            "bit",
            "black",
            "blood",
            "blue",
            "board",
            "body",
            "book",
            "born",
            "both",
            "box",
            "boy",
             "break",

            "brother",
             "budget",
            "build",
             "building",
            "business",
            "but",
            "buy",
            "by",
            "call",
            "camera",
            "campaign",
            "can",
            "cancer",
            "candidate",
            "capital",
            "car",
            "card",
    "care",
            "career",
    "carry",
            "case",
            "catch",
            "cause",
            "cell",
            "eight",
            "either",
            "election",
            "else",
            "employee","foreign",
                    "forget",
           " form",
            "former",
             "forward",
            "four",
            "free",
            "friend",
             "from",
            "front",
            "full",
            "political",
            "politics",
            "poor",
            "popular",
            "population"};
    String s1,s2;
    EditText e1;
    Button b1,b2,b3,b4,b5;
    TextView t1;
    TextToSpeech te;
    Random r;
    int High,Low,Result;
    int marks=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//full Screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        e1=(EditText)findViewById(R.id.enter);
        b1=(Button)findViewById(R.id.bsk);
        b2=(Button)findViewById(R.id.go);
        r = new Random();
         Low = 0;
         High = 95;
         Result = r.nextInt(High-Low) + Low;
        b4=(Button)findViewById(R.id.play);
        b3=(Button)findViewById(R.id.stop);
        t1=(TextView)findViewById(R.id.result);
        b5=(Button)findViewById(R.id.replay);
        s2=arr[Result];

        te=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                te.setSpeechRate(0.3f);
                te.setPitch(0.6f);
                te.setLanguage(Locale.ENGLISH);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Third.class);
                startActivity(i);
                finish();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String s3=e1.getText().toString();
                if(s3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Write the word",Toast.LENGTH_SHORT).show();
                }
                else{


                if(s3.equals(s2)) {
                    marks++;
                }
                Result = r.nextInt(High-Low) + Low;
                while(hash[Result]!=0){
                    Result = r.nextInt(High-Low) + Low;

                }
                s2=arr[Result];
                te.speak(s2,TextToSpeech.QUEUE_ADD,null);
                hash[Result]=1;
                e1.setText("");

            }}
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                while(hash[Result]!=0){
                    Result = r.nextInt(High-Low) + Low;

                }
                  te.speak(s2,TextToSpeech.QUEUE_ADD,null);
                hash[Result]=1;
                t1.setText("");

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("Your Score is: "+marks);
                te.speak("Your Score is: "+marks,TextToSpeech.QUEUE_ADD,null);

                marks=0;
                for(int i=0;i<=94;i++)
                {
                    hash[i]=0;
                }
            }

        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                te.speak(s2,TextToSpeech.QUEUE_ADD,null);

            }
        });
    }
}
