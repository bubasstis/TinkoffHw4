package com.example.sem.tinkoffhw4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import static com.example.sem.tinkoffhw4.R.id.update;


public class MainActivity extends Activity {
    Button firstTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(getClass().getName(), "[onCreate(activity)]");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTask = findViewById(update);


        firstTask.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startTask();

            }
        });

    }

    @Override
    protected void onDestroy() {
        Log.d(getClass().getName(), "[onDestroy(activity)]");
        super.onDestroy();
    }

    private void startTask() {
        FirstTaskFragment fragment = FirstTaskFragment.newInstance();
        getFragmentManager().beginTransaction().add(fragment, "updateText").commit();
        fragment.startTask();
    }
}
