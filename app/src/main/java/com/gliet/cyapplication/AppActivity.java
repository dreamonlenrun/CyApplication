package com.gliet.cyapplication;


import com.example.changyi_core.activities.ProxyActivity;
import com.example.changyi_core.delegate.ChangYiDelegate;

public class AppActivity extends ProxyActivity {

    @Override
    public ChangYiDelegate setRootDelegate() {
        return new AppDelegate();
    }
}
