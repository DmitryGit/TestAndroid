package com.nca.presentation.screen.user.usermvp;

import android.app.Activity;
import android.content.Intent;

import com.nca.presentation.base.Router;
import com.nca.presentation.screen.user.UserViewModelCW14;

public class UserRouter extends Router {

    public UserRouter(Activity activity) {
        super(activity);
    }

    public void navigateToUser(String id) {
        // первый варинат
        // второй параметр куда переходим на какую активити
        Intent intent = new Intent(getActivity(), UserViewModelCW14.class);
        intent.putExtra("key", id);
        getActivity().startActivity(intent);

        //альтернативный вариант
//        UserActivity.show(getActivity(), id)
    }

    public void back() {
        getActivity().onBackPressed();
    }
}
