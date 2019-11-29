package com.example.changyi_core.delegate;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by Tong on 2019/11/28
 */
public abstract class BaseDelegate extends SwipeBackFragment  {
    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;
    public abstract Object setLayout();
    public abstract void onBindView( @Nullable Bundle savedInstanceState,View rootView);
    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        //传递資源文件ID
        if(setLayout() instanceof Integer){
            rootView=inflater.inflate((Integer) setLayout(),container,false);
        }else if(setLayout() instanceof  View){
            rootView = (View) setLayout();
        }
        if(rootView!=null){
            mUnbinder = ButterKnife.bind(this,rootView);
            onBindView(savedInstanceState,rootView);
        }
        return rootView;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        if(mUnbinder != null){
            mUnbinder.unbind();
        }
        super.onDestroy();
    }
}
