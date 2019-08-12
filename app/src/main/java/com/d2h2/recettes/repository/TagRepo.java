package com.d2h2.recettes.repository;

import androidx.annotation.NonNull;

import com.d2h2.recettes.model.Tag;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TagRepo {

    public interface EventListener {
        void onDataChange();
        void onCancelled();
    }

    private final List<Tag> mTags = new ArrayList<>();

    private final DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference("tags");

    private final List<TagRepo.EventListener> mListeners = new ArrayList<>();

    private static final TagRepo ourInstance = new TagRepo();

    private final ValueEventListener mValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            mTags.clear();
            for(DataSnapshot data : dataSnapshot.getChildren()) {
                Tag tag = new Gson().fromJson(data.getValue(false).toString(), Tag.class);
                mTags.add(tag);
            }
            for(TagRepo.EventListener listener : mListeners) {
                listener.onDataChange();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            for(TagRepo.EventListener listener : mListeners) {
                listener.onCancelled();
            }
        }
    };

    private TagRepo() {
        mDatabaseRef.addValueEventListener(mValueEventListener);
    }

    // api

    static TagRepo getInstance() {
        return ourInstance;
    }

    public void addEventListener(EventListener listener) {
        mListeners.add(listener);
    }

    public void removeEventLisstener(EventListener listener) {
        mListeners.remove(listener);
    }

    public List<Tag> getList() {
        return mTags;
    }

    public Tag findById(int id) {
        Tag result = null;
        for(Tag tag : mTags) {
            if(tag.getId() == id) {
                result = tag;
                break;
            }
        }
        return result;
    }

    public void add(Tag TagToAdd) {
        // TODO
    }

    public void delete(Tag TagToDelete) {
        // TODO
    }

    public void delete(int idToDelete) {
        // TODO
    }

    public void update(Tag TagToUpdate) {
        // TODO
    }
}
