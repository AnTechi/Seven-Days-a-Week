package com.example.sevendaysaweek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class Signup_user extends AppCompatActivity {
    private EditText name,email_id,phone,gen,dateofbirth,password;
    String name_register,email_id_register,phone_register,gen_register,dateofbirth_register,password_register;
    int id=1;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    private Toolbar toolbar;
    public TextView gender_txt;
    private String gender;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_user);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        //Toolbar settings
        {
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("Sign Up");
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
         name=findViewById(R.id.Signup_Name);
        email_id=findViewById(R.id.Signup_Email);
        phone=findViewById(R.id.Signup_Phone);
        gen=findViewById(R.id.Signup_Gender);
        dateofbirth=findViewById(R.id.Signup_Age);
        password=findViewById(R.id.Signup_Password);
        gender_txt=findViewById(R.id.Signup_Gender);
        dateView = (TextView) findViewById(R.id.Signup_Age);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
       // showDate(year, month+1, day);





    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }



    public void Display_genderdialog(View view)
    {
        GetGender();

    }


    //get gender dialog box..
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

    //birth date picker..
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
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    //Registering Data on localhost
    public void UserRegister(View view)
    {

        name_register =name.getText().toString();
        email_id_register=email_id.getText().toString().trim();
        phone_register=phone.getText().toString();
        gen_register=gen.getText().toString();
        dateofbirth_register=dateofbirth.getText().toString();
        password_register=password.getText().toString().trim();
        String email = email_id_register;

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
if(TextUtils.isEmpty(name_register) || TextUtils.isEmpty(email_id_register)|| TextUtils.isEmpty(phone_register)||TextUtils.isEmpty(gen_register) || TextUtils.isEmpty(dateofbirth_register) ||TextUtils.isEmpty(password_register))
{
    Toast.makeText(this, "(*)Fields are mandatory", Toast.LENGTH_SHORT).show();
}

    else {
        if(email.matches(emailPattern)){
            String method = "register";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, Integer.toString(id), name_register, email_id_register, phone_register, gen_register, dateofbirth_register, password_register);
            id = id + 1;
            RegisterUser();
        }
        else{
            Toast.makeText(this, "Invalid EmailAddress", Toast.LENGTH_SHORT).show();}
}



    }


    //Registering User on Firebase
    private void RegisterUser()
    {

        if(TextUtils.isEmpty(email_id_register))
        {
            Toast.makeText(this,"enter email",Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(password_register))
        {
            Toast.makeText(this,"enter epassword",Toast.LENGTH_LONG).show();
        }


        progressDialog.setMessage("Registering.....");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email_id_register,password_register).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {


                    VerifyEmail();
                    progressDialog.dismiss();
                    Intent loginIntent=new Intent(Signup_user.this,Login_Avtivity.class);
                    Signup_user.this.startActivity(loginIntent);
                    Toast.makeText(Signup_user.this,"succesful",Toast.LENGTH_LONG).show();
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(Signup_user.this,"not succesful",Toast.LENGTH_LONG).show();
                }
            }
        });




}

//Sending Verification email
public void VerifyEmail()
{
    firebaseUser.sendEmailVerification()
            .addOnCompleteListener(this, new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    // Re-enable button


                    if (task.isSuccessful()) {
                        Toast.makeText(Signup_user.this,
                                "Verification email sent to " + firebaseUser.getEmail(),
                                Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(Signup_user.this,
                                "Failed to send verification email.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
}


    public void Login(View view)
    {
        startActivity(new Intent(this,Login_Avtivity.class));

    }
}
