package com.gliet.cyapplication;

import android.os.Bundle;
import android.view.View;

import com.example.changyi_core.delegate.ChangYiDelegate;

import androidx.annotation.Nullable;

public class AppDelegate extends ChangYiDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_app;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
