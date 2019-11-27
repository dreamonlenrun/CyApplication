package com.example.changyi_core.app;

import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by Tong on 2019/11/27
 */
public final class ChangYi {
    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getCyConfigs();
    }
}
