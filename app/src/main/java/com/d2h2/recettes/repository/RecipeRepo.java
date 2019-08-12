package com.d2h2.recettes.repository;

import androidx.annotation.NonNull;

import com.d2h2.recettes.model.Recipe;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepo {

    public interface EventListener {
        void onDataChange();
        void onCancelled();
    }

    private final List<Recipe> mRecipes = new ArrayList<>();

    private final DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference("recipes");

    private final List<EventListener> mListeners = new ArrayList<>();

    private static final RecipeRepo ourInstance = new RecipeRepo();

    private final ValueEventListener mValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            mRecipes.clear();
            for(DataSnapshot data : dataSnapshot.getChildren()) {
                Recipe recipe = new Gson().fromJson(data.getValue(false).toString(), Recipe.class);
                mRecipes.add(recipe);
            }
            for(EventListener listener : mListeners) {
                listener.onDataChange();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            for(EventListener listener : mListeners) {
                listener.onCancelled();
            }
        }
    };

    private RecipeRepo() {
        mDatabaseRef.addValueEventListener(mValueEventListener);
    }

    // api

    public static synchronized RecipeRepo getInstance() {
        return ourInstance;
    }

    public void addEventListener(EventListener listener) {
        mListeners.add(listener);
    }

    public void removeEventLisstener(EventListener listener) {
        mListeners.remove(listener);
    }

    public List<Recipe> getList() {
        return mRecipes;
    }

    public Recipe findById(int id) {
        Recipe result = null;
        for(Recipe recipe : mRecipes) {
            if(recipe.getId() == id) {
                result = recipe;
                break;
            }
        }
        return result;
    }

    public List<Recipe> findByOwnerId(int[] ownerId) {
        final List<Recipe> result = new ArrayList<>();
        // TODO
        return result;

    }

    public List<Recipe> findByTagId(int[] tagId) {
        final List<Recipe> result = new ArrayList<>();
        // TODO
        return result;

    }

    public List<Recipe> findByIngredientId(int[] ingredientId) {
        final List<Recipe> result = new ArrayList<>();
        // TODO
        return result;
    }

    public void add(Recipe recipeToAdd) {
        // TODO
    }

    public void delete(Recipe recipeToDelete) {
        // TODO
    }

    public void delete(int idToDelete) {
        // TODO
    }

    public void update(Recipe recipeToUpdate) {
        // TODO
    }

}
