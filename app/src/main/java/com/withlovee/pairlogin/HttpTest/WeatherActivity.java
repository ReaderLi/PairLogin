package com.withlovee.pairlogin.HttpTest;


import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;


import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;

import com.withlovee.pairlogin.R;

/**
 * Created by Administrator on 2015/8/27.
 */
public class WeatherActivity extends Activity {

    private ActionBar actionBar;

    private String TAG="WeatherActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.weather);

        Log.i(TAG,"onCreate");
        actionBar=getActionBar();

        actionBar.setCustomView(R.layout.actionbar_title);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

    }
}