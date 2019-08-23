package com.d2h2.recettes.ui.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d2h2.recettes.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AddImageAdapter extends RecyclerView.Adapter<AddImageAdapter.ViewHolder> {

    private ArrayList<Uri> listUri;
    private LayoutInflater layoutInflater;

    public AddImageAdapter(ArrayList<Uri> listUri) {
        this.listUri = listUri;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_image,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Uri uri = listUri.get(i);
        Picasso.get().load(uri).resize(300,300).into(viewHolder.image);
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listUri.remove(viewHolder.getPosition());
                notifyItemRemoved(viewHolder.getPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUri.size();
    }

    public ArrayList<Uri> getListUri(){
        return listUri;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image, delete;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_image);
            delete = (ImageView) itemView.findViewById(R.id.deleteButton);
        }

    }
}