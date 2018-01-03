package com.example.aniketkumar.netcamp_app;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class Media_palyer extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    ImageView i1;
    MediaPlayer mp,mq,mw;
    int i=0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 10){
            Uri uriSound=data.getData();
            play(this, uriSound);
        }
    }
    private void play(Context context, Uri uri) {

        try {
            MediaPlayer mp = new MediaPlayer();
            mp.setDataSource(context, uri);
            mp.start();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,//full Screen
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_palyer);
        b1=(Button)findViewById(R.id.bsk);
        b2=(Button)findViewById(R.id.play);
        b3=(Button)findViewById(R.id.pause);
        b4=(Button)findViewById(R.id.next);
        b5=(Button)findViewById(R.id.filemanager);
        i1=(ImageView)findViewById(R.id.image);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                Intent i=new Intent(getApplicationContext(),Third.class);
                startActivity(i);
                finish();
            }
        });
        mp=new MediaPlayer();
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,10);
            }
        });
        mp=MediaPlayer.create(this,R.raw.a);
//        mq=new MediaPlayer();
//        mq=MediaPlayer.create(this,R.raw.b);
//        mw=new MediaPlayer();
//        mw=MediaPlayer.create(this,R.raw.c);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mp.start();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
//                mq.pause();
//                mw.pause();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                 i++;
                if(i==1) {
                   mp.reset();
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.b);
                    mp.start();
                }
                else if(i==2) {
                 //   mq.stop();
                    mp.reset();
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.c);
                    mp.start();
                }
                else {
                    i = 0;
                    mp.reset();
                    mp=MediaPlayer.create(getApplicationContext(),R.raw.a);
                    mp.start();
                 }

            }

        });


    }
}
