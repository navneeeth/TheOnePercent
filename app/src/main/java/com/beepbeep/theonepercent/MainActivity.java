package com.beepbeep.theonepercent;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Thread thread;
    int progress;
    Intent intent;
    Button buttonx;
    TextView tv12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress=0;
        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        tv12 = findViewById(R.id.textView12);
        buttonx = findViewById(R.id.button3);
        buttonx.setVisibility(View.INVISIBLE);
        tv12.setVisibility(View.VISIBLE);
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
           while (progress<=100) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               progress=progress+10;
               progressBar.setProgress(progress);
               System.out.println("Current progress = " + progress);
           }


                System.out.println("outside the while");
                if(progress >= 100) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("inside uiThread");
                            tv12.setVisibility(View.INVISIBLE);
                            buttonx.setVisibility(View.VISIBLE);
                            buttonx.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    intent = new Intent(MainActivity.this, Main2Activity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }

           }
            });
            thread.start();


        }
    }

