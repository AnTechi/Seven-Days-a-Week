package com.example.sevendaysaweek;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Stage2UserInfo extends AppCompatActivity {
    private EditText FullNameTxt,SocialSecurityTxt,PresentAddressTxt,PresentCityTxt,PresentStateTxt,PresentZipTxt,
            PermanentAddressTxt,PermanentCityTxt,PermanentStateTxt,PermanentZipTxt,PresentCountryTxt
            ,PermanentCountryTxt,PositionTxt,SalaryDesiredTxt,PresentEmployerTxt,ExperienceTxt,AcountHolderNameTxt,
            AcountNumberTxt,BankNameTxt,BranchCodeTxt,IfscCodeTxt,BankCityTxt;



    public String FullName,SocialSecurity,PresentAddress,PresentCity,PresentState,PresentZip,
            PermanentAddress,PermanentCity,PermanentState,PermanentZip,PresentCountry
            ,PermanentCountry,Position,SalaryDesired,PresentEmployer,Experience,AcountHolderName,
            AcountNumber,BankName,BranchCode,IfscCode,BankCity;
   public String [] desc;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private RecycleAdapter adapter;


    private RadioGroup CurrentlyEmplyedRadioGrp;
    private RadioButton Rb;
    private TextView WorkStartDate;
    private int year, month, day;
    private Calendar calendar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2_user_info);
        EducationDetailsActivity educationDetailsActivity=new EducationDetailsActivity();


        {  //EditText
            FullNameTxt = findViewById(R.id.FullnameTxt);
            SocialSecurityTxt = findViewById(R.id.SocialSecurityTxt);
            PresentAddressTxt = findViewById(R.id.PresentAddressTxt);
            PresentCityTxt = findViewById(R.id.PresentCityTxt);
            PresentStateTxt = findViewById(R.id.PresentStateTxt);
            PresentCountryTxt = findViewById(R.id.PresentCountryTxt);
            PresentZipTxt = findViewById(R.id.PresentZipTxt);
            PermanentAddressTxt = findViewById(R.id.PermanentAddressTxt);
            PermanentCityTxt = findViewById(R.id.PermanentCityTxt);
            PermanentStateTxt = findViewById(R.id.PermanentStateTxt);
            PermanentZipTxt = findViewById(R.id.PermanentZipTxt);
            PermanentCountryTxt = findViewById(R.id.PermanentCountryTxt);
            PositionTxt = findViewById(R.id.PositionTxt);
            SalaryDesiredTxt = findViewById(R.id.SalaryDesiredTxt);
            PresentEmployerTxt = findViewById(R.id.PreviousEmployer);
            ExperienceTxt = findViewById(R.id.Experience);
            AcountHolderNameTxt = findViewById(R.id.AccountHolderNameTxt);
            AcountNumberTxt = findViewById(R.id.AccountNumberTxt);
            BankCityTxt = findViewById(R.id.BankCityTxt);
            BankNameTxt = findViewById(R.id.BankNameTxt);
            BranchCodeTxt = findViewById(R.id.BranchCodeTxt);
            IfscCodeTxt = findViewById(R.id.IFSCcodeTxt);
            WorkStartDate = findViewById(R.id.WorkStartDateTxt);
            CurrentlyEmplyedRadioGrp = findViewById(R.id.CurrentlyEmployedRadioBn);
        }



        //Strings
        {
            FullName=FullNameTxt.getText().toString();
            PresentAddress=PresentAddressTxt.getText().toString();
            SocialSecurity=SocialSecurityTxt.getText().toString();
            PresentEmployer=PresentEmployerTxt.getText().toString();
            PresentZip=PresentZipTxt.getText().toString();
            PresentCountry=PresentCountryTxt.getText().toString();
            PresentState=PresentStateTxt.getText().toString();
            PresentCity=PresentCityTxt.getText().toString();
            PermanentCountry=PermanentCountryTxt.getText().toString();
            PermanentZip=PermanentZipTxt.getText().toString();
            PermanentState=PermanentStateTxt.getText().toString();
            PermanentCity=PermanentCityTxt.getText().toString();
            PermanentAddress=PermanentAddressTxt.getText().toString();
            Position=PositionTxt.getText().toString();
            SalaryDesired=SalaryDesiredTxt.getText().toString();
            AcountNumber=AcountNumberTxt.getText().toString();
            AcountHolderName=AcountHolderNameTxt.getText().toString();
            BankName=BankNameTxt.getText().toString();
            BankCity=BankCityTxt.getText().toString();
            BranchCode=BranchCodeTxt.getText().toString();
            IfscCode=IfscCodeTxt.getText().toString();

        }





        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

    }


    //START DATE PICKER..
    public void setDate(View view) {
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
        WorkStartDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    //Currently Employed Status..
    public void CurrentlyEmployed(View view)
    {
        int RId=CurrentlyEmplyedRadioGrp.getCheckedRadioButtonId();
        Rb=(RadioButton)findViewById(RId);
        if(Rb==findViewById(R.id.No))
        {
            ExperienceTxt.setVisibility(View.GONE);
            PresentEmployerTxt.setVisibility(View.GONE);
        }
        else
        {
            ExperienceTxt.setVisibility(View.VISIBLE);
            PresentEmployerTxt.setVisibility(View.VISIBLE);
        }
    }



    //
    public void Next()
    {
        if(TextUtils.isEmpty(FullName) || TextUtils.isEmpty(PresentAddress) || TextUtils.isEmpty(SocialSecurity) || TextUtils.isEmpty(PresentCity) ||
                TextUtils.isEmpty(PresentState) || TextUtils.isEmpty(PresentZip) || TextUtils.isEmpty(PermanentAddress) ||
                TextUtils.isEmpty(PermanentCity) || TextUtils.isEmpty(PermanentState) || TextUtils.isEmpty(PermanentZip) || TextUtils.isEmpty(Position) ||
                TextUtils.isEmpty(SalaryDesired)  || TextUtils.isEmpty(AcountHolderName) ||
                TextUtils.isEmpty(AcountNumber) || TextUtils.isEmpty(BranchCode) || TextUtils.isEmpty(IfscCode) || TextUtils.isEmpty(BankName) || TextUtils.isEmpty(BankCity) )
        {
            Toast.makeText(this, "All Fields are mandatory", Toast.LENGTH_SHORT).show();
        }
    }



    public void openActivity(View view)
    {



        startActivityForResult(new Intent(this,EducationDetailsActivity.class),99);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99)
        {
            String degree=data.getStringExtra("DEGREE");
            String institute=data.getStringExtra("INSTITUTE");
            String education=data.getStringExtra("EDUCATIONTYPE");
            String startdate=data.getStringExtra("STARTDATE");
            String passoutdate=data.getStringExtra("PASSOUTDATE");

            desc=new String[5];
            desc[0]=degree;
            desc[1]=institute;
            desc[2]=education;
            desc[3]=startdate;
            desc[4]=passoutdate;

            recyclerView=findViewById(R.id.EducationRecyclerView);
            layoutManager=new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            adapter=new RecycleAdapter(desc);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
        }
    }


}
