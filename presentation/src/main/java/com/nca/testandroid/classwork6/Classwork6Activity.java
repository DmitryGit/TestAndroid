package com.nca.testandroid.classwork6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nca.testandroid.R;

import java.util.ArrayList;
import java.util.List;

public class Classwork6Activity extends AppCompatActivity {

    private static final String TAG = Classwork6Activity.class.getSimpleName();

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork6);

        List<User> userList = new ArrayList<>();
//http://happyticket555.ru/wp-content/uploads/2012/01/%D1%83%D0%BB%D1%83%D1%87%D1%88%D0%B5%D0%BD%D0%B8%D0%B5_%D0%B7%D1%80%D0%B5%D0%BD%D0%B8%D1%8F_ylyghenie_zrenia1.jpg
        userList.add(new User("http://happyticket555.ru/wp-content/uploads/2012/01/%D1%83%D0%BB%D1%83%D1%87%D1%88%D0%B5%D0%BD%D0%B8%D0%B5_%D0%B7%D1%80%D0%B5%D0%BD%D0%B8%D1%8F_ylyghenie_zrenia1.jpg", "Ivanov 1", "Ivan 1"));
        userList.add(new User("", "Ivanov 2", "Ivan 2"));
        userList.add(new User("", "Ivanov 3", "Ivan 3"));
        userList.add(new User("", "Ivanov 4", "Ivan 4"));
        userList.add(new User("", "Ivanov 5", "Ivan 5"));

        userAdapter = new UserAdapter();
        userAdapter.setUserList(userList);

        userAdapter.setListener(new UserAdapter.OnUserClickListener() {
            @Override
            public void onClick(User user, int position) {
                Toast.makeText(Classwork6Activity.this, user.getName() + position, Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // если нужно колонками то нижний
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        // если нужно плитками неравномерными
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(this, );
        recyclerView.setHasFixedSize(true);

//        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onRause()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
    }
}
