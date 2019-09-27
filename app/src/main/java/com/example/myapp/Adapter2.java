package com.example.myapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder>{
    private LayoutInflater layoutInflater;
    ViewGroup viewGroup;
    private List<String> data2;
    Adapter2 (Context context, List<String> data2) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data2 = data2;
    }
    @Override
    public Adapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view=layoutInflater.inflate(R.layout.custom_layout2, viewGroup, false);
        return new Adapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter2.ViewHolder holder, int i) {
        String Title= data2.get(i);
        Adapter2.ViewHolder.textTitle.setText(Title);
    }

    @Override
    public int getItemCount() {
        return data2.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        static TextView textTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle= itemView.findViewById(R.id.textView_all);

        }
    }
}
