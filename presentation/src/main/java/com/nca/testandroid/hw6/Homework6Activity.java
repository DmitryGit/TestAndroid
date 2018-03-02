package com.nca.testandroid.hw6;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nca.testandroid.R;
import com.nca.testandroid.classwork6.User;
import com.nca.testandroid.classwork6.UserAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Homework6Activity extends AppCompatActivity {

    private static final String TAG = Homework6Activity.class.getSimpleName();

    private RecyclerView recyclerView;
    private PeopleAdapter peopleAdapter;
    private List<People> peopleList;
    private EditText inputSearch;

    private ProgressBar progressBar;
    private Timer timer;

    private TextWatcher searchTextWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable arg0) {
            // user typed: start the timer
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // do your actual work here
                    Homework6Activity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.VISIBLE);
                            recyclerView.setVisibility(View.INVISIBLE);
                            Homework6Activity.this.peopleAdapter.filter(inputSearch.getText().toString());
                        }
                    });

                    // задержка для проверки прогрессбара
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Homework6Activity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.INVISIBLE);
                            recyclerView.setVisibility(View.VISIBLE);
                        }
                    });

                    // hide keyboard as well?
                     InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                     in.hideSoftInputFromWindow(inputSearch.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }, 600); // 600ms delay before the timer executes the "run" method from TimerTask
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // nothing to do here
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // user is typing: reset already started timer (if existing)
            if (timer != null) {
                timer.cancel();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework6);

        inputSearch = findViewById(R.id.inputSearch);
        progressBar = findViewById(R.id.progressBar);


        peopleList = (List<People>)JsonParser.parseFromJson(JsonParser.readJsonFileFromAssets(this, "test.json"), TestFile.class) ;

        peopleAdapter = new PeopleAdapter();
        peopleAdapter.setPeopleList(peopleList);

        peopleAdapter.setListener(new PeopleAdapter.OnUserClickListener() {
            @Override
            public void onClick(People people, int position) {
                Toast.makeText(Homework6Activity.this, people.getName() + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(peopleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        inputSearch.addTextChangedListener(searchTextWatcher);

    }
}
