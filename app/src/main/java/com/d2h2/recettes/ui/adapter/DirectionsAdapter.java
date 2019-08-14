package com.d2h2.recettes.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d2h2.recettes.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DirectionsAdapter extends RecyclerView.Adapter<DirectionsAdapter.DirectionViewHolder> {

    private final List<String> data;

    public DirectionsAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public DirectionsAdapter.DirectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.directions_item, parent, false);
        return new DirectionsAdapter.DirectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectionsAdapter.DirectionViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class DirectionViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_direction)
        TextView directionTextView;

        DirectionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(String direction){
            directionTextView.setText(direction);
        }
    }
}
