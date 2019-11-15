package com.example.sevendaysaweek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPassword_activity extends AppCompatActivity {
    private EditText ResetEmail;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_activity);
        ResetEmail=findViewById(R.id.ResetPaasword_Email);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=firebaseAuth.getInstance();

    }

    public void ResetPassword(View view)
    {
        final String email=ResetEmail.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Enter email..!!", Toast.LENGTH_SHORT).show();
        }
        else {
            progressDialog.setMessage("Sending Reset Password link to "+email);
            progressDialog.show();
            firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        Toast.makeText(ResetPassword_activity.this, "Reset password link sent to " + email, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ResetPassword_activity.this,Login_Avtivity.class));
                        finish();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(ResetPassword_activity.this, "Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
