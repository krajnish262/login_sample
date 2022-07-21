package com.example.hksrajnishtask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hksrajnishtask.R;
import com.example.hksrajnishtask.model.SortingModel;

import java.util.ArrayList;
import java.util.List;

public class SortingAdapter extends RecyclerView.Adapter<SortingAdapter.ViewHolder> {

    ArrayList<String> mid_value;
    ArrayList<String> tid_value;
    ArrayList<String> amount_value;
    ArrayList<String> narration_value;
    Context context;

    public SortingAdapter(ArrayList<String> mid_value, ArrayList<String> tid_value, ArrayList<String> amount_value, ArrayList<String> narration_value, Context context) {
        this.mid_value = mid_value;
        this.tid_value = tid_value;
        this.amount_value = amount_value;
        this.narration_value = narration_value;
        this.context = context;
    }

    @NonNull
    @Override
    public SortingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sorting_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mid.setText(mid_value.get(position));
        holder.tid.setText(tid_value.get(position));
        holder.amount.setText(amount_value.get(position));
        holder.narration.setText(narration_value.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, mid_value.get(position), Toast.LENGTH_SHORT);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mid_value.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mid, tid, amount, narration;


        public ViewHolder(View itemView) {
            super(itemView);
            mid = itemView.findViewById(R.id.Mid_value);
            tid = itemView.findViewById(R.id.tid_value);
            amount = itemView.findViewById(R.id.amount_value);
            narration = itemView.findViewById(R.id.narration_value);

        }
    }
}
