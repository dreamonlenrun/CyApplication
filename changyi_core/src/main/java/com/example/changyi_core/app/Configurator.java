package com.example.changyi_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tong on 2019/11/27
 * 配置文件
 */
public class Configurator {
    private  static final HashMap<String,Object> CY_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        CY_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final  HashMap<String,Object> getCyConfigs(){
        return CY_CONFIGS;
    }
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final  void configure(){
        initIcons();
        CY_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final  Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return  this;
    }
    public final  Configurator withApiHost(String host){
        CY_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return  this;
    }

    private void checkConfiguration(){
        final  boolean isReady =(boolean)CY_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    private void initIcons(){
        if(ICONS.size()>0){
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for(int i =1;i<ICONS.size();i++){
                initializer.with(ICONS.get(i));
            }
        }
    }

    @SuppressWarnings("unchecked")
    final  <T> T getConfiruration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) CY_CONFIGS.get(key.name());
    }
}
