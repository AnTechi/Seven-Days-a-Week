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
        EducationDetailsActivity educationDetailsActivity=new EducationDetailsActivity();

        private String[]desc;
        private Context context;
        public RecycleAdapter(String [] desc,Context context){
            this.desc=desc;
            this.context=context;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.educationlayout,parent,false);
            MyViewHolder myViewHolder=new MyViewHolder(view,context,desc);

            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
           // String image_id=desc[position];
            holder.degree.setText(educationDetailsActivity.educationlist.get(0));
            holder.institute.setText(educationDetailsActivity.educationlist.get(1));
            holder.educationtype.setText(educationDetailsActivity.educationlist.get(2));
            holder.startdate.setText(educationDetailsActivity.educationlist.get(3));
            holder.passout.setText(educationDetailsActivity.educationlist.get(4));
        }

        @Override
        public int getItemCount() {
            return educationDetailsActivity.educationlist.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView degree,institute,startdate,passout,educationtype;
            String []desc;
            Context context;
            public MyViewHolder(View itemView,Context context,String[]desc) {
                super(itemView);
               degree=itemView.findViewById(R.id.DegreenameTxt);
                institute=itemView.findViewById(R.id.InstitutenameTxt);
                startdate=itemView.findViewById(R.id.StartTxt);
                passout=itemView.findViewById(R.id.PassoutyearTxt);
                educationtype=itemView.findViewById(R.id.EducationTypeTxt);
                this.desc=desc;
                this.context=context;

            }
        }



    }