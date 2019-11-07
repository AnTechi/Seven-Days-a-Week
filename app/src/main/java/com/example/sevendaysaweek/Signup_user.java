package com.example.sevendaysaweek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup_user extends AppCompatActivity {

    public TextView gender_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);

        gender_txt=findViewById(R.id.Signup_Gender);
    }

    public void Display_genderdialog(View view)
    {
        new Gender_dialog().show(getSupportFragmentManager(),"genderdialog");


    }
}
