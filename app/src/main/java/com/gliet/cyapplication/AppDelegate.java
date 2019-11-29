package com.gliet.cyapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.changyi_core.delegate.ChangYiDelegate;
import com.example.changyi_core.net.RestClient;
import com.example.changyi_core.net.callback.IError;
import com.example.changyi_core.net.callback.IFailure;
import com.example.changyi_core.net.callback.ISuccess;

import androidx.annotation.Nullable;

public class AppDelegate extends ChangYiDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_app;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        Log.e("tttt","onBindView");
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://news.baidu.com/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                        Log.d("testtest",response);
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.e("tttt","IFailure");
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Log.e("tttt",code +msg);
                    }
                })
                .build()
                .get();
    }
}
