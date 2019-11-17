package com.example.sevendaysaweek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EducationDetailsActivity extends AppCompatActivity {

    private EditText Degreename,Institutename,Educationtype;
   private TextView Startdate,Passout;
    public List<String> educationlist;
public String array[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details);
        Degreename=findViewById(R.id.DegreenameActTxt);
        Institutename=findViewById(R.id.InstitutenameActTxt);
        Educationtype=findViewById(R.id.EducationTypeActTxt);
        Startdate=findViewById(R.id.StartActTxt);
        Passout=findViewById(R.id.PassoutyearActTxt);
        String degreenamestr,institutenamestr,educationtypestr,startdatestr,passoutstr;
        degreenamestr=Degreename.getText().toString().trim();
        institutenamestr=Degreename.getText().toString().trim();
        educationtypestr=Degreename.getText().toString().trim();
        startdatestr=Degreename.getText().toString().trim();
        passoutstr=Degreename.getText().toString().trim();
//        educationlist=new ArrayList<>();
//        array=new String[5];
//        array[0]=degreenamestr;
//        array[1]=institutenamestr;
//        array[2]=educationtypestr;
//        array[3]=startdatestr;
//        array[4]=passoutstr;
        educationlist= Arrays.asList(degreenamestr,institutenamestr,educationtypestr,startdatestr,passoutstr);
//        educationlist.add(degreenamestr,institutenamestr,educationtypestr,startdatestr,passoutstr);


    }
}
