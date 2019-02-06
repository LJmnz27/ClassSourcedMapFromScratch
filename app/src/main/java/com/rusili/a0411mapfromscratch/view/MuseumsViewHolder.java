package com.rusili.a0411mapfromscratch.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rusili.a0411mapfromscratch.R;
import com.rusili.a0411mapfromscratch.model.Museum;

public class MuseumsViewHolder extends RecyclerView.ViewHolder {
    private TextView museum_name;

    public MuseumsViewHolder(@NonNull View itemView) {
        super(itemView);
        museum_name = itemView.findViewById(R.id.museum_name);
    }

    public void onBind(final Museum object) {
        museum_name.setText(object.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentInterface fragmentInterface = (FragmentInterface) itemView.getContext();
                fragmentInterface.startMap(object);
            }
        });
    }
}
