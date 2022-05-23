package com.example.minipro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText emaileditText,passwordeditText;
    Button button;
    Button signInBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emaileditText=findViewById(R.id.emaileditText); // value fetching
        passwordeditText=findViewById(R.id.passwordeditText); //value fetching from activity xml
        button=findViewById(R.id.button);
    }

    public void Signup(View view) {
        String email=emaileditText.getText().toString();
        String password=passwordeditText.getText().toString();

        if (!isValidPassword(password)){
            Toast.makeText(MainActivity.this,"Password does not match rules",Toast.LENGTH_LONG).show();
            Toast.makeText(MainActivity.this,"password is not valid",Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent=new Intent(MainActivity.this,LoginActivity.class); // arguments go with the activities which are to be interactive
        intent.putExtra("email",email);
        intent.putExtra("password",password);  //transfer data from one activity to another instead of database
        startActivity(intent);


    }

    public void signIn(View view) {
        String email=emaileditText.getText().toString();
        String password=passwordeditText.getText().toString();

        Intent intent=new Intent(MainActivity.this,pseudologin.class);
        startActivity(intent);


    }
    // next function....
    Pattern lowercase=Pattern.compile("^.*[a-z].*$");
    Pattern uppercase=Pattern.compile("^.*[A-Z].*$");
    Pattern number=Pattern.compile("^.*[0-9].*$");
    Pattern specialcharacter=Pattern.compile("^.*[^a-zA-Z0-9].*$");
    private Boolean isValidPassword(String password){
        if (password.length()<8){
            return false;
        }
        if (!lowercase.matcher(password).matches()){
            return false;
        }
        if (!uppercase.matcher(password).matches()){
            return false;
        }
        if (!number.matcher(password).matches()){
            return false;
        }
        if (!specialcharacter.matcher(password).matches()){
            return false;
        }
        return true;
    }

}