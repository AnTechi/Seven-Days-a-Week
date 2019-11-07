package com.example.sevendaysaweek;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup_user extends AppCompatActivity {

    public TextView gender_txt;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);

        gender_txt=findViewById(R.id.Signup_Gender);
    }

    public void Display_genderdialog(View view)
    {
        GetGender();

    }
    public void GetGender()
    {

        final String[] gen=this.getResources().getStringArray(R.array.genderarr);
       AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Select your Gender");
        builder.setSingleChoiceItems(R.array.genderarr, -1, new DialogInterface.OnClickListener() {
                    @Override

                    public void onClick(DialogInterface dialogInterface, int i) {

                        gender=gen[i];
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        gender_txt.setText(gender);


                    }
                });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();





    }
}
