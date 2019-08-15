package com.d2h2.recettes.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d2h2.recettes.R;
import com.d2h2.recettes.data.Repo.CommentsRepo;
import com.d2h2.recettes.data.Repository;
import com.d2h2.recettes.data.model.Comment;
import com.d2h2.recettes.data.model.Recipe;
import com.d2h2.recettes.ui.adapter.CommentAdapter;
import com.d2h2.recettes.ui.adapter.HomeAdapter;
import com.d2h2.recettes.util.AppUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FragmentComments extends Fragment {

    @BindView(R.id.tv_username)
    TextView userNameTextView;
    @BindView(R.id.edt_comment)
    EditText commentEditText;
    @BindView(R.id.btn_comment)
    Button commentButton;
    @BindView(R.id.rv_comments)
    RecyclerView recyclerView;
    private Recipe data;

    private CompositeDisposable compositeDisposable;

    FragmentComments(Recipe recipe){
        this.data = recipe;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        compositeDisposable = new CompositeDisposable();
        initView(view);
        initAction();
    }

    private void initView(View view){
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initAction(){
        Repository repository = AppUtil.getRepository();
        Disposable disposable = repository.getComments(data.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        compositeDisposable.add(disposable);

    }

    private void onSuccess(CommentsRepo commentsRepo){
        List<Comment> comments = commentsRepo.getComments();
        recyclerView.setAdapter(new CommentAdapter(comments));

    }

    private void onError(Throwable e){
        Log.d("dinh", "onError: " + e);
        Toast.makeText(getContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
    }
}
