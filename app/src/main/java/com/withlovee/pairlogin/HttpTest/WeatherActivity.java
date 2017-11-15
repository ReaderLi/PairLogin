package com.withlovee.pairlogin.HttpTest;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.withlovee.pairlogin.R;

/**
 * Created by Administrator on 2015/8/27.
 */
public class WeatherActivity extends Activity {

    private ActionBar actionBar;

    private Button button1;

    private String TAG="WeatherActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.weather);

        Log.i(TAG,"onCreate");
        actionBar=getActionBar();

        actionBar.setCustomView(R.layout.actionbar_title);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        button1 = (Button) findViewById(R.id.button_sensorPage);
        if(button1 != null){

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.i(TAG,"button_sensorPage onClick");

                    Intent intent = new Intent(WeatherActivity.this,SensorActivity.class);
                    startActivity(intent);
                }


            });
        }


    }
}