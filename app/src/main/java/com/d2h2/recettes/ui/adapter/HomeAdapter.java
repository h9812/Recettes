package com.d2h2.recettes.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d2h2.recettes.R;
import com.d2h2.recettes.ui.fragment.listener.RecipeSelectedListener;
import com.d2h2.recettes.data.model.Recipe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private RecipeSelectedListener recipeSelectedListener;
    private final List<Recipe> data;

    public HomeAdapter(List<Recipe> data, RecipeSelectedListener recipeSelectedListener){
        this.data = data;
        this.recipeSelectedListener = recipeSelectedListener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        return new HomeViewHolder(view, recipeSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static final class HomeViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_recipe_name)
        TextView recipeNameTextView;
        @BindView(R.id.tv_recipe_description) TextView recipeDescriptionTextView;

        private Recipe recipe;

        HomeViewHolder(@NonNull View itemView, final RecipeSelectedListener recipeSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if(recipe != null) {
                    recipeSelectedListener.onRecipeSelected(recipe);
                }
            });
        }

        void bind(Recipe recipe){
            this.recipe = recipe;
            recipeNameTextView.setText(recipe.getName());
            recipeDescriptionTextView.setText(recipe.getDescription());
        }
    }
}
