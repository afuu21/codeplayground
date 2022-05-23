package com.example.minipro1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.provider.ContactsContract;



public class studentapp extends AppCompatActivity {

    EditText e1,e2; //input elements fetching objects
    TextView tv1,tv02,tv03;
    Button iainfo;
    Button callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentapp);

        e1 = (EditText)findViewById(R.id.editText1);
        e2 = (EditText)findViewById(R.id.editText2);
        tv1 = (TextView)findViewById(R.id.textView4);
        tv02 = (TextView)findViewById(R.id.tv02);
        tv03 = (TextView)findViewById(R.id.tv03);

        callBtn = findViewById(R.id.callBtn);
    }

    public void iainfo(View view) {


        Intent intent=new Intent(studentapp.this,iaInfo.class);
        startActivity(intent);


    }

    public void caller(View V){
        Intent intent1= new Intent(Intent.ACTION_DIAL);
        startActivity(intent1);

    }

    public void attendance(View V)
    {
        float a1 = Integer.parseInt(e1.getText().toString());
        float a2 = Integer.parseInt(e2.getText().toString());
        float results = (a1/a2)*100;

        tv1.setText("Attendance :"+results+"%");

        if(results>=75 ){
            tv02.setText("Attendance is greater than 75%");
            tv03.setText("");

        }
        else
        {
            tv03.setText("Attendance is less than 75%,Please Contact H.O.D");
            tv02.setText("");
        }






    }
}