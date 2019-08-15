package com.d2h2.recettes.ui.fragment.listener;

import android.widget.TextView;

import com.d2h2.recettes.data.model.Recipe;

public interface RecipeSelectedListener {
    void onRecipeSelected(Recipe recipe);
    void onLikeSelected(Recipe recipe, TextView view);
}
