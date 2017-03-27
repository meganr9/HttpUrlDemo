package com.meagain.httpurldemo;

import android.content.Context;
import android.os.AsyncTask;

import java.util.LinkedList;

/**
 * Created by Megan on 2/3/2017.
 */

public class GetTweetAsyncTask extends AsyncTask<String, Void, LinkedList<String>> {
    IData activity;

    public GetTweetAsyncTask(Main2Activity activity) {
        this.activity = activity;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected LinkedList<String> doInBackground(String... params) {
        LinkedList<String> tweets = new LinkedList<>();
        tweets.add("Tweet 0");
        tweets.add("Tweet 1");
        tweets.add("Tweet 2");
        tweets.add("Tweet 3");
        return tweets;
    }

    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.</p>
     * <p>
     * <p>This method won't be invoked if the task was cancelled.</p>
     *
     * @param result The result of the operation computed by {@link #doInBackground}.
     * @see #onPreExecute
     * @see #doInBackground
     * @see #onCancelled(Object)
     */
    @Override
    protected void onPostExecute(LinkedList<String> result) {
        activity.setupData(result);
        super.onPostExecute(result);
    }

    static public interface IData{
        public void setupData(LinkedList<String> result);
        public Context getContext();
    }


}
