package com.example.sevendaysaweek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Avtivity extends AppCompatActivity {
    private EditText LoginEmail,LoginPassword;
    private TextView Forgotpass;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser User;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__avtivity);
        LoginEmail=findViewById(R.id.Login_Email);
        Forgotpass=findViewById(R.id.textView);
        LoginPassword=findViewById(R.id.Login_Password);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=firebaseAuth.getInstance();
        User=firebaseAuth.getCurrentUser();



    }

    //Login buttonClick
    public void LoginUser(View view)
    {
        UserLogin();
    }


    //Firebase Login Steps
    //Checking email and password
    private void UserLogin() {
        String email = LoginEmail.getText().toString().trim();
        String password = LoginPassword.getText().toString().trim();

        //checking if email and password is empty..
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }

        else {

            progressDialog.setMessage("Loging in.....");
            progressDialog.show();


            //email verification mail sending using firebase..
            if (User.isEmailVerified()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //open main activity if login is successful..
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            Intent intent = new Intent(Login_Avtivity.this, MainActivity.class);
                            Login_Avtivity.this.startActivity(intent);

                            Toast.makeText(Login_Avtivity.this, "Login succesful", Toast.LENGTH_LONG).show();
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(Login_Avtivity.this, "Incorrect Email or Password ", Toast.LENGTH_LONG).show();
                        }
                    }
                });


            } else {
                progressDialog.dismiss();
                Toast.makeText(Login_Avtivity.this, "not verified", Toast.LENGTH_LONG).show();
            }
        }
    }




    //forgot password button click
    //opening reset password activity..
    public void ForgotPassword(View view)
    {
        startActivity(new Intent(this,ResetPassword_activity.class));
    }
}
