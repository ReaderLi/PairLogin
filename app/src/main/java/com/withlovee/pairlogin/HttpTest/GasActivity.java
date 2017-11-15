package com.withlovee.pairlogin.HttpTest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.withlovee.pairlogin.R;

public class GasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置隐藏ActionBar
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gas);
    }

}
