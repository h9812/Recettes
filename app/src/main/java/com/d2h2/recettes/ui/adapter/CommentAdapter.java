package com.d2h2.recettes.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d2h2.recettes.R;
import com.d2h2.recettes.data.model.Comment;
import com.d2h2.recettes.data.model.Recipe;
import com.d2h2.recettes.ui.fragment.listener.CommentSelectedListener;
import com.d2h2.recettes.ui.fragment.listener.RecipeSelectedListener;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private CommentSelectedListener mCommentSelectedListener;
    private final List<Comment> mListComment;

    public CommentAdapter(List<Comment> ListComment){ mListComment = ListComment;
    }

    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentAdapter.CommentViewHolder(view, mCommentSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {
        holder.bind(mListComment.get(position));
    }

    @Override
    public int getItemCount() {
        return mListComment.size();
    }

    static final class CommentViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_avatar)
        ImageView ImgAvatar;
        @BindView(R.id.txt_name) TextView TxtName;
        @BindView(R.id.txt_comment) TextView TxtComment;
        @BindView(R.id.txt_time_date) TextView TimeDate;

        private Comment comment;

        CommentViewHolder(@NonNull View itemView, final CommentSelectedListener commentSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if(comment != null && commentSelectedListener != null) {
                    commentSelectedListener.onCommentSelected(comment);
                }
            });
        }

        void bind(Comment comment){
            this.comment = comment;
                TxtComment.setText(comment.getContent());
                TimeDate.setText(comment.getModifiedDate().toString());
//            recipeDescriptionTextView.setText(recipe.getDescription());
        }
    }
}
