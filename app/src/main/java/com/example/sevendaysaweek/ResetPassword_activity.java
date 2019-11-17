package com.example.sevendaysaweek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPassword_activity extends AppCompatActivity {
    private EditText ResetEmail;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Toolbar toolbar;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_activity);
        ResetEmail=findViewById(R.id.ResetPaasword_Email);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=firebaseAuth.getInstance();

        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Reset Password");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

    public void ResetPassword(View view)
    {
        final String email=ResetEmail.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Enter email..!!", Toast.LENGTH_SHORT).show();
        }
        else if(email.matches(emailPattern)){
            progressDialog.setMessage("Sending Reset Password link to "+email);
            progressDialog.show();
            firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        Toast.makeText(ResetPassword_activity.this, "Reset password link sent to " + email, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(ResetPassword_activity.this,LoginActivity.class));
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
        else
        {
            Toast.makeText(ResetPassword_activity.this, "Incorrect Email", Toast.LENGTH_LONG).show();
        }
    }
}
