package com.nca.presentation.screen.user.usermvp;

import com.nca.presentation.base.BasePresenter;
import com.nca.presentation.screen.user.list.UserAdapter;

public abstract class UserPresenter extends BasePresenter<UserView, UserRouter> {

    public abstract UserAdapter getUserAdapter();
    public abstract void onUserClick();


}
