package com.example.sevendaysaweek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class EducationDetailsActivity extends AppCompatActivity {

    private EditText Degreename,Institutename,Educationtype;
    private TextView Startdate,Passout,date;
    private Toolbar toolbar;
    private int year, month, day;
    private Calendar calendar;
    public String degreenamestr,institutenamestr,educationtypestr,startdatestr,passoutstr;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details);
        Degreename=findViewById(R.id.DegreenameActTxt);
        Institutename=findViewById(R.id.InstitutenameActTxt);
        Educationtype=findViewById(R.id.EducationTypeActTxt);
        Startdate=findViewById(R.id.StartActTxt);
        Passout=findViewById(R.id.PassoutyearActTxt);



        toolbar=findViewById(R.id.whitetoolbar);

        toolbar.setTitle("");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Strings
            degreenamestr = Degreename.getText().toString().trim();
            institutenamestr = Degreename.getText().toString().trim();
            educationtypestr = Degreename.getText().toString().trim();
            startdatestr = Degreename.getText().toString().trim();
            passoutstr = Degreename.getText().toString().trim();



        {  //Date PIcker
            calendar = Calendar.getInstance();

            year = calendar.get(Calendar.YEAR);

            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
        }

    }


    public void NotEmptyFields()
    {

    }




    //START DATE PICKER..
    public void setDate(TextView date) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        date.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    public void SetEducationDetails(View view)
    {

        if(TextUtils.isEmpty(degreenamestr) || TextUtils.isEmpty(institutenamestr) ||  TextUtils.isEmpty(educationtypestr) ||
                TextUtils.isEmpty(startdatestr) || TextUtils.isEmpty(degreenamestr) )
        {
            Toast.makeText(this, "All Fields are mandatory", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent();
            intent.putExtra("DEGREE", Degreename.getText().toString());
            intent.putExtra("INSTITUTE", Institutename.getText().toString());
            intent.putExtra("EDUCATIONTYPE", Educationtype.getText().toString());
            intent.putExtra("STARTDATE", Startdate.getText().toString());
            intent.putExtra("PASSOUTDATE", Passout.getText().toString());
            setResult(99, intent);
            finish();
        }//finishing activity
    }

    public void setStartDate(View view) {
        date=findViewById(R.id.StartActTxt);
        setDate(date);

    }

    public void setPassoutDate(View view) {
        date=findViewById(R.id.PassoutyearActTxt);
        setDate(date);
    }
}
