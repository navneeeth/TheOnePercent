package com.beepbeep.theonepercent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {
    Button buttony;
    Intent intent6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        intent6 = new Intent(Main5Activity.this, Main3Activity.class);
        buttony = findViewById(R.id.button4);
        buttony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent6);
            }
        });
    }
}
