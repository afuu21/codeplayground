package com.example.minipro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText TextEmailAddress,TextPassword;
    Button button2;
    int counter=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextEmailAddress=findViewById(R.id.textEmailAddress); // value fetching
        TextPassword=findViewById(R.id.textPassword); //value fetching from activity xml
        button2=findViewById(R.id.button2);
    }

    public void login(View view) {

        String registeredemail=getIntent().getStringExtra("email");

        String registeredpwd=getIntent().getStringExtra("password");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=TextEmailAddress.getText().toString();
                String password=TextPassword.getText().toString();

                if(registeredemail.equals(email) && registeredpwd.equals(password)){
                    Intent intent=new Intent(LoginActivity.this,studentapp.class);
                    startActivity(intent);
                }
                else {


                        Toast.makeText(LoginActivity.this, "Password does not match", Toast.LENGTH_LONG).show();
                    
                }
                counter--;
                if(counter==0)
                {
                    Toast.makeText(getBaseContext(),"FAILED LOGIN ATTEMPTS",Toast.LENGTH_LONG).show();
                    button2.setEnabled(false);
                }
            }
        });
    }
}