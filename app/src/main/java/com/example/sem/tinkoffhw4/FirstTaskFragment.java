package com.example.sem.tinkoffhw4;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FirstTaskFragment extends Fragment {


    public static FirstTaskFragment newInstance() {
        return new FirstTaskFragment();
    }

    private AsyncTask<Void, String, Void> task;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(getClass().getName(), "[onCreate]");
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onDestroy() {
        Log.d(getClass().getName(), "[onDestroy]");
        super.onDestroy();

        if (task != null) {
            task.cancel(true);
        }
    }


    public void startTask() {
        task = new UpdateAsyncTask();
        task.execute();
    }

    private class UpdateAsyncTask extends AsyncTask<Void, String, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress("Я выполниль запрос ");

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            updateTextView(values[0]);
        }

        private void updateTextView(String text) {
            final Activity activity = getActivity();
            if (activity == null) {
                return;
            }

            final TextView textView = ((TextView) activity.findViewById(R.id.text));
            if (textView == null) {
                return;
            }
            textView.setText(text);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d(getClass().getName(), "[onAttach]");
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        Log.d(getClass().getName(), "[onDetach]");
        super.onDetach();
    }
}