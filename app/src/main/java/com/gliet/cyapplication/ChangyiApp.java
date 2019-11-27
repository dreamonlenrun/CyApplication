package com.gliet.cyapplication;

import android.app.Application;

import com.example.changyi.ec.icon.FontEcModule;
import com.example.changyi_core.app.ChangYi;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class ChangyiApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ChangYi.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1")
                .configure();

    }
}
