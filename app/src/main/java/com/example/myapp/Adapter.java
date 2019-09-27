package com.example.myapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    ViewGroup viewGroup;
    private List<String> data;
    Adapter (Context context, List<String> data){
        this.layoutInflater= LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view=layoutInflater.inflate(R.layout.custom_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        String Title= data.get(i);
        ViewHolder.textTitle.setText(Title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        static TextView textTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            textTitle= itemView.findViewById(R.id.textView);

        }
    }
}
