package com.withlovee.pairlogin.Fragment;

import android.content.Context;
import android.graphics.PixelFormat;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;


import com.withlovee.pairlogin.R;

/**
 * Created by LRD on 2017/11/16.
 */

public class UserCenterFragment extends Fragment {

    private View View = null;
    private ViewGroup.LayoutParams wmParams = null;
    // 用于显示右下角浮动图标
    private ImageView img_Float = null;
    private String TAG="UserCenterFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_user_center, container, false);
        Log.i(TAG,"onCreateView");



        // TODO Auto-generated method stub
        return view;
    }



}
