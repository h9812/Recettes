package com.d2h2.recettes.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.d2h2.recettes.R;
import com.d2h2.recettes.ui.fragment.listener.RecipeSelectedListener;
import com.d2h2.recettes.data.model.Recipe;
import com.d2h2.recettes.util.AppUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

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

        @BindView(R.id.tv_user) TextView userTextView;
        @BindView(R.id.imv_avatar)
        CircleImageView avatarImageView;
        @BindView(R.id.tv_recipe_name)
        TextView recipeNameTextView;
        @BindView(R.id.tv_recipe_description) TextView recipeDescriptionTextView;
        @BindView(R.id.tv_time) TextView timeTextView;
        @BindView(R.id.images_container)
        LinearLayout imageContainerLayout;

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
            userTextView.setText("Tran Van Dinh");
            recipeNameTextView.setText(recipe.getName());
            recipeDescriptionTextView.setText(recipe.getDescription());
            timeTextView.setText("1h truoc");
            for(int index = 0; index < recipe.getImages().size(); index ++){
                ImageView imageView = new ImageView(itemView.getContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setPadding(0, 0, 8,0);
                Glide.with(itemView).load(AppUtil.IP + recipe.getImages().get(index)).into(imageView);
                imageContainerLayout.addView(imageView);
            }
        }
    }
}
