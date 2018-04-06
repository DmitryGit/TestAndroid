package com.nca.presentation.screen.user;

import android.app.Activity;
import android.content.Intent;

import com.nca.presentation.base.Router;

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
