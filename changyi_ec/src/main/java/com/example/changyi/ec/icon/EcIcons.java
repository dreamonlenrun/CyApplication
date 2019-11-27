package com.example.changyi.ec.icon;

import com.joanzapata.iconify.Icon;

public enum  EcIcons implements Icon {
    icon_tt1('\ue606'),
    icon_tt2('\ue606');

    private char  charactor;

    EcIcons(char charactor) {
        this.charactor = charactor;
    }

    @Override
    public String key() {
        return null;
    }

    @Override
    public char character() {
        return charactor;
    }
}
