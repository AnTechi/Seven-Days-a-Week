package com.example.sevendaysaweek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Avtivity extends AppCompatActivity {
    private EditText LoginEmail,LoginPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser User;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__avtivity);
        LoginEmail=findViewById(R.id.Login_Email);
        LoginPassword=findViewById(R.id.Login_Password);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=firebaseAuth.getInstance();
        User=firebaseAuth.getCurrentUser();
    }

    public void LoginUser(View view)
    {

        UserLogin();
    }

    private void UserLogin()
    {
        String email=LoginEmail.getText().toString().trim();
        String password=LoginPassword.getText().toString().trim();

        progressDialog.setMessage("Loging in.....");
        progressDialog.show();
        User.reload();

//            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//
//                    if (task.isSuccessful()) {
//                        progressDialog.dismiss();
//                        Intent intent = new Intent(Login_Avtivity.this, MainActivity.class);
//                        Login_Avtivity.this.startActivity(intent);
//
//                        Toast.makeText(Login_Avtivity.this, "succesful", Toast.LENGTH_LONG).show();
//                    } else {
//                        progressDialog.dismiss();
//                        Toast.makeText(Login_Avtivity.this, "Email or Password does not match", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
        boolean h=User.isEmailVerified();
        System.out.println(h);




    }

}
