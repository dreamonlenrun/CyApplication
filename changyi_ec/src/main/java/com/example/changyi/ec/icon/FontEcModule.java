package com.example.changyi.ec.icon;
import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;
public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
        //return new Icon[0];
    }
}
