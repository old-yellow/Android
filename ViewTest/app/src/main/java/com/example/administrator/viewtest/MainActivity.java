package com.example.administrator.viewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.circle_button) {
            Intent intent = new Intent(this, CircleActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.view_ex_button) {
            Intent intent = new Intent(this, ScrollExActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.d(TAG, "onWindowFocusChanged: focus:" + hasFocus);
        super.onWindowFocusChanged(hasFocus);
    }
}
