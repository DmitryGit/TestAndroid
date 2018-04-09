package com.nca.presentation.screen.user.usermvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nca.domain.entity.UserEntity;
import com.nca.presentation.base.BaseMvpActivity;
import com.nca.presentation.screen.user.UserRouter;
import com.nca.testandroid.R;

public class UserActivityPresenter extends BaseMvpActivity<UserPresenter, UserRouter> implements UserView {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserPresenter providePresenter() {
        return new SignUserPresenter();
    }

    @Override
    public UserRouter provideRouter() {
        return new UserRouter(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(presenter.getUserAdapter());
        presenter.onUserClick();

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showError(Exception e) {

    }

    @Override
    public void showUser(UserEntity userEntity) {
        // закидываем данные в xml, например в TextView, пердвариетльно делать findViewById
    }


}

// android google github sample architecture