package com.d2h2.recettes.repository;

import androidx.annotation.NonNull;

import com.d2h2.recettes.model.Ingredient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

class IngredientRepo {

    public interface EventListener {
        void onDataChange();
        void onCancelled();
    }

    private final List<Ingredient> mIngredients = new ArrayList<>();

    private final DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference("ingredients");

    private final List<IngredientRepo.EventListener> mListeners = new ArrayList<>();

    private static final IngredientRepo ourInstance = new IngredientRepo();

    private final ValueEventListener mValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            mIngredients.clear();
            for(DataSnapshot data : dataSnapshot.getChildren()) {
                Ingredient ingredient = new Gson().fromJson(data.getValue(false).toString(), Ingredient.class);
                mIngredients.add(ingredient);
            }
            for(IngredientRepo.EventListener listener : mListeners) {
                listener.onDataChange();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            for(IngredientRepo.EventListener listener : mListeners) {
                listener.onCancelled();
            }
        }
    };

    private IngredientRepo() {
        mDatabaseRef.addValueEventListener(mValueEventListener);
    }

    // api

    static IngredientRepo getInstance() {
        return ourInstance;
    }
   
    public void addEventListener(EventListener listener) {
        mListeners.add(listener);
    }

    public void removeEventLisstener(EventListener listener) {
        mListeners.remove(listener);
    }

    public List<Ingredient> getList() {
        return mIngredients;
    }

    public Ingredient findById(int id) {
        Ingredient result = null;
        for(Ingredient ingredient : mIngredients) {
            if(ingredient.getId() == id) {
                result = ingredient;
                break;
            }
        }
        return result;
    }

    public void add(Ingredient ingredientToAdd) {
        // TODO
    }

    public void delete(Ingredient ingredientToDelete) {
        // TODO
    }

    public void delete(int idToDelete) {
        // TODO
    }

    public void update(Ingredient ingredientToUpdate) {
        // TODO
    }
}
