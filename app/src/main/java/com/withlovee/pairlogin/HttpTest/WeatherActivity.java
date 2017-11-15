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
        actionBar.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }
}