package com.beepbeep.theonepercent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
    EditText editText3;
    EditText editText4;
    Intent intent3;
    Intent intent4;
    Button button2;
    String mail, pwd;
    FirebaseAuth firebase1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button2 = findViewById(R.id.button2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        firebase1 = FirebaseAuth.getInstance();
        intent4 = new Intent(Main3Activity.this, Main5Activity.class);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = editText3.getText().toString();
                pwd = editText4.getText().toString();
                if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(pwd) || pwd.length()<7)
                {
                    if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(pwd) && pwd.length()>7)
                    {
                        Toast.makeText(Main3Activity.this, "Error 1", Toast.LENGTH_LONG).show();
                    }
                    else if(pwd.length()<7)
                    {
                        Toast.makeText(Main3Activity.this, "Error 2", Toast.LENGTH_LONG).show();
                    }
                    startActivity(intent4);
                }
                else {
                    firebase1.createUserWithEmailAndPassword(mail, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Main3Activity.this, "Successfully joined!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Main3Activity.this, Main4Activity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(Main3Activity.this, "Error 3", Toast.LENGTH_LONG).show();
                                startActivity(intent4);
                            }
                        }
                    });

                }            }
        });
    }
}
