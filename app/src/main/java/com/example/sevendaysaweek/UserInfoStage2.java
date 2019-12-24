package com.example.sevendaysaweek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class UserInfoStage2 extends AppCompatActivity {

    private Toolbar toolbar;
    Spinner countrylist;
    AutoCompleteTextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_stage2);

        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("INFORMATION");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hello=(AutoCompleteTextView)findViewById(R.id.hello);
        countrylist=(Spinner)findViewById(R.id.spinner);


    }

    public void AddEducation(View view) {
        startActivityForResult(new Intent(this,EducationDetailsActivity.class),99);
    }

    public void GetCountryList(View view)
    {

        Locale[] locale=Locale.getAvailableLocales();
        ArrayList<String> countries=new ArrayList<>();
        String Country;
        for(Locale loc:locale)
        {
            Country=loc.getDisplayCountry();
            if(Country.length()>0 && !countries.contains(Country)){
                countries.add(Country);
            }
        }
        Collections.sort(countries,String.CASE_INSENSITIVE_ORDER);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,countries);
        hello.setAdapter(adapter);
    }
}
