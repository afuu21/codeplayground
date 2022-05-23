package com.example.minipro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class pseudologin extends AppCompatActivity {

    EditText EmailAddress2,Password2;
    Button plogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pseudologin);

        EmailAddress2=findViewById(R.id.textEmailAddress2); // value fetching
        Password2=findViewById(R.id.textPassword2); //value fetching from activity xml
        plogin=findViewById(R.id.plogin);


    }

    public void pseudolog(View view) {
        String email=EmailAddress2.getText().toString();
        String password=Password2.getText().toString();

        if (!isValidPassword(password)){
            Toast.makeText(pseudologin.this,"Password does not match rules",Toast.LENGTH_LONG).show();
            Toast.makeText(pseudologin.this,"password is not valid",Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent=new Intent(pseudologin.this,studentapp.class); // arguments go with the activities which are to be interactive
        intent.putExtra("email",email);
        intent.putExtra("password",password);  //transfer data from one activity to another instead of database
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