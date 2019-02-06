package com.rusili.a0411mapfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusili.a0411mapfromscratch.R;
import com.rusili.a0411mapfromscratch.model.Museum;
import com.rusili.a0411mapfromscratch.view.MuseumsViewHolder;

import java.util.List;

public class MuseumsAdapter extends RecyclerView.Adapter<MuseumsViewHolder> {
    private List<Museum> museumList;

    public MuseumsAdapter(List<Museum> museumList){
        this.museumList = museumList;
    }

    @NonNull
    @Override
    public MuseumsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.museum_list, viewGroup, false);
        return new MuseumsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumsViewHolder holder, int i) {
        holder.onBind(museumList.get(i));
    }

    @Override
    public int getItemCount() {
        return museumList.size();
    }
}
