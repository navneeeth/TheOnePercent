package com.beepbeep.theonepercent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    EditText editText2;
    Button button;
    Intent intent1;
    Intent intent2;
    Intent intent7;
    FirebaseAuth firebase = FirebaseAuth.getInstance();
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        intent7 = new Intent(Main2Activity.this, Main6Activity.class);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editText.getText().toString();
                password = editText.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(Main2Activity.this, "Error 1", Toast.LENGTH_LONG).show();
                    startActivity(intent7);
                }
                else
                firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            intent1 = new Intent(Main2Activity.this, Main4Activity.class);
                            startActivity(intent1);
                        }
                        else
                        {
                            Toast.makeText(Main2Activity.this, "Error 2", Toast.LENGTH_LONG).show();
                            startActivity(intent7);
                        }
                    }
                });

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            intent2 = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(intent2);
            }
        });
    }
}
