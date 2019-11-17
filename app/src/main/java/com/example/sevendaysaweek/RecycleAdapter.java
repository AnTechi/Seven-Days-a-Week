package com.example.sevendaysaweek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    public class RecycleAdapter extends RecyclerView.Adapter <RecycleAdapter.MyViewHolder>  {


        private String[]descarr;

        public RecycleAdapter(String[] desc){

       this.descarr=desc;

        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.educationlayout,parent,false);
            MyViewHolder myViewHolder=new MyViewHolder(view);

            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
           // String image_id=desc[position];
            holder.degree.setText(descarr[0]);
            holder.institute.setText(descarr[1]);
            holder.educationtype.setText(descarr[2]);
            holder.startdate.setText(descarr[3]);
            holder.passout.setText(descarr[4]);
        }

        @Override
        public int getItemCount() {
            return 1;
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView degree,institute,startdate,passout,educationtype;

            public MyViewHolder(View itemView) {
                super(itemView);
                degree=itemView.findViewById(R.id.DegreenameTxt);
                institute=itemView.findViewById(R.id.InstitutenameTxt);
                startdate=itemView.findViewById(R.id.StartTxt);
                passout=itemView.findViewById(R.id.PassoutyearTxt);
                educationtype=itemView.findViewById(R.id.EducationTypeTxt);


            }
        }



    }