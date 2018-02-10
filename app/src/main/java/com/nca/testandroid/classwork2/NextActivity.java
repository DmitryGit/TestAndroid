package com.nca.testandroid.classwork2;

    import android.app.Activity;
    import android.os.Bundle;
    import android.support.annotation.Nullable;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    import com.nca.testandroid.R;
    import com.nca.testandroid.classwork2.Singleton;


public class NextActivity extends Activity {

    public static final String KET_TEXT = " KET_TEXT";

    private Button button1;


    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            Singleton singleton = Singleton.getInstance();
            if (singleton.text.contains("Hello")) {
                Log.e("AAA", "contain");
            } else {
                Log.e("AAA","not contain");
            }

            String text = getIntent().getStringExtra(KET_TEXT);
            button1.setText(text);

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(listener);

    }




}