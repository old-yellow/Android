package com.example.administrator.playvideotest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play = (Button)findViewById(R.id.play);
        Button pause = (Button)findViewById(R.id.pause);
        Button replay = (Button)findViewById(R.id.replay);
        videoView = (VideoView)findViewById(R.id.video_view);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.
                WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initVideoPath();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play :
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.pause :
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.replay :
                if (videoView.isPlaying()) {
                    videoView.resume();
                }
                break;
            default:
        }
    }

    private void initVideoPath() {
        File file = new File(Environment.getExternalStorageDirectory(),
                "/Android/obb/com.xunlei.downloadprovider/ThunderDownload/阳光电影www.ygdy8." +
                        "com.暴裂无声.HD.1080p.国语中英双字.mp4");
        videoView.setVideoPath(file.getPath());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initVideoPath();
                } else {
                    Toast.makeText(MainActivity.this, "权限不足", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }
}
