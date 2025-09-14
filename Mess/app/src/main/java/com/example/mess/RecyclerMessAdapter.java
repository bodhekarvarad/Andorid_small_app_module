package com.example.mess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerMessAdapter extends RecyclerView.Adapter<RecyclerMessAdapter.ViewHolder> {

    Context context;
    ArrayList<Contact_model_mess> arrContacts;
    RecyclerMessAdapter(Context context, ArrayList<Contact_model_mess> arrContacts){
        this.context=context;
        this.arrContacts=arrContacts;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v=LayoutInflater.from(context).inflate(R.layout.contact_row_mess,parent,false);

        ViewHolder viewHolder=new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).contact);
        holder.txtAdd.setText(arrContacts.get(position).name);

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtNumber,txtAdd;
        ImageView imgContact;
        public ViewHolder(View itemView){
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtAdd=itemView.findViewById(R.id.txtAdd);
            txtNumber=itemView.findViewById(R.id.txtContact);
            imgContact=itemView.findViewById(R.id.image1);
        }

    }

}
