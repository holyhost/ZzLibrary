package com.zxyoyo.apk.zzlibrary;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.FormViewHolder> {


    @NonNull
    @Override
    public FormViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FormViewHolder formViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FormViewHolder extends RecyclerView.ViewHolder {

        public FormViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
