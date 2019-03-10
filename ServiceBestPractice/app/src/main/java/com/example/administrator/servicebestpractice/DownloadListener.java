package com.example.administrator.servicebestpractice;

/**
 * Created by Administrator on 2019/3/9.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPause();

    void onCanceled();
}
