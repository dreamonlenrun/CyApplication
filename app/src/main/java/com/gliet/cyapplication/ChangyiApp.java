package com.gliet.cyapplication;

import android.app.Application;

import com.example.changyi.ec.icon.FontEcModule;
import com.example.changyi_core.app.ChangYi;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.joanzapata.iconify.fonts.MeteoconsModule;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.joanzapata.iconify.fonts.TypiconsModule;
import com.joanzapata.iconify.fonts.WeathericonsModule;

public class ChangyiApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ChangYi.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withIcon(new TypiconsModule())
                .withIcon(new MaterialModule())
                .withIcon(new MaterialCommunityModule())
                .withIcon(new MeteoconsModule())
                .withIcon(new WeathericonsModule())
                .withIcon(new SimpleLineIconsModule())
                .withIcon(new IoniconsModule())
                .withApiHost("http://127.0.0.1")
                .configure();

    }
}
