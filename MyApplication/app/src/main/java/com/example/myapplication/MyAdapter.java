package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * creation date: 2019-12-25 11:00
 * description ：
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewPagerHolder> {


    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pager, parent, false);
        return new ViewPagerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        holder.mTextView.setText(String.format(String.valueOf(position), "%s Pager"));

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewPagerHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;

        public ViewPagerHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_text);
        }
    }
}
