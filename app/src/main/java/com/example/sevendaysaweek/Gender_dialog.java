package com.example.sevendaysaweek;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.sevendaysaweek.MainActivity;
import com.example.sevendaysaweek.R;
import com.example.sevendaysaweek.Signup_user;

public class Gender_dialog extends DialogFragment {

    private String gender;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final String[] gen=getActivity().getResources().getStringArray(R.array.genderarr);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
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

                Signup_user signup_user=new Signup_user();
                signup_user.gender_txt.setText(gender);



            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });




        return super.onCreateDialog(savedInstanceState);
    }
}

