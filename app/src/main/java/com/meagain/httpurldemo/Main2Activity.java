package com.meagain.httpurldemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class Main2Activity extends AppCompatActivity implements GetTweetAsyncTask.IData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        new GetTweetAsyncTask(this).execute("some url");

    }


    @Override
    public void setupData(LinkedList<String> result) {
        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, result);
        listView.setAdapter(adapter);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
