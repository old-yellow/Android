package com.example.administrator.materialtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class ScActivity extends AppCompatActivity {

    public static final String SC_NAME = "starcraft_name";

    public static final String SC_IMAGE_ID = "starcraft_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sc);
        Intent intent = getIntent();
        String scName = intent.getStringExtra(SC_NAME);
        int scImgId = intent.getIntExtra(SC_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
        ImageView scImageView = (ImageView)findViewById(R.id.sc_image_view);
        TextView scContentText = (TextView)findViewById(R.id.sc_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(scName);
        Glide.with(this).load(scImgId).into(scImageView);
        String scContent = generateScContent(scName);
        scContentText.setText(scContent);
    }

    private String generateScContent(String scName) {
        StringBuilder scContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            scContent.append(scName);
        }
        return scContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
