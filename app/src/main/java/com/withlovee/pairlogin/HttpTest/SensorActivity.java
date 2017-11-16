package com.withlovee.pairlogin.HttpTest;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.withlovee.pairlogin.R;

public class SensorActivity extends Activity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        actionBar = getActionBar();

        actionBar.setCustomView(R.layout.actionbar_title_sensorpage);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

    }
}
