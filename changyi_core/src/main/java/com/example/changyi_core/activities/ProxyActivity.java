package com.example.changyi_core.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.changyi_core.R;
import com.example.changyi_core.delegate.ChangYiDelegate;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ContentFrameLayout;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract ChangYiDelegate setRootDelegate();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    /**
     * 初始化視圖
     */
    private void initContainer(@Nullable Bundle savedInstanceState){
        @SuppressLint("RestrictedApi")
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if(savedInstanceState ==null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
