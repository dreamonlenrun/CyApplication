package com.example.changyi_core.app;

import android.content.Context;
import android.os.Handler;

/**
 * Created by Tong on 2019/11/27
 */
public final class ChangYi {
    public static Configurator init(Context context){
        Configurator.getInstance()
                .getCyConfigs()
                .put(ConfigType.APPLICATION_CONTEXT,context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }
    public static Context getApplicationContext() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }
    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER);
    }
    /*
    public static HashMap<Object,Object> getConfigurations(){
        return Configurator.getInstance().getCyConfigs();
    }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT);
    }
*/



}
