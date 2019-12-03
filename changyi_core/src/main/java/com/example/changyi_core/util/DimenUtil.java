package com.example.changyi_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.changyi_core.app.ChangYi;

public class DimenUtil {
    public static  int getScreenWidth(){
        final Resources resources = ChangYi.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = ChangYi.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
