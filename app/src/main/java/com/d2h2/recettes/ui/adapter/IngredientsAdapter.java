package com.d2h2.recettes.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d2h2.recettes.R;
import com.d2h2.recettes.data.model.Ingredient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder> {

    private final List<Ingredient> ingredients;
    private final List<String> amounts;

    public IngredientsAdapter(List<Ingredient> ingredients, List<String> amounts) {
        this.ingredients = ingredients;
        this.amounts = amounts;
    }

    @NonNull
    @Override
    public IngredientsAdapter.IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_item, parent, false);
        return new IngredientsAdapter.IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsAdapter.IngredientsViewHolder holder, int position) {
        holder.bind(ingredients.get(position), amounts.get(position));
    }

    @Override
    public int getItemCount() {
        return amounts.size();
    }

    static class IngredientsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_ingredient)
        TextView ingredientTextView;
        @BindView(R.id.tv_amount) TextView amountTextView;

        IngredientsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Ingredient ingredient, String amount){
            ingredientTextView.setText(ingredient.getName());
            amountTextView.setText(amount);
        }
    }
}
