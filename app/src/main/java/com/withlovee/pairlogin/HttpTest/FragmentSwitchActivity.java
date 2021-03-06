package com.withlovee.pairlogin.HttpTest;


import android.app.ActionBar;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.withlovee.pairlogin.R;

public class FragmentSwitchActivity extends FragmentActivity implements GestureDetector.OnGestureListener {

    public static Fragment[] fragments;
    public static LinearLayout[] linearLayouts;
    public static TextView[] textViews;
    /**定义手势检测实例*/
    public static GestureDetector detector;
    /**做标签，记录当前是哪个fragment*/
    public int MARK=0;
    /**定义手势两点之间的最小距离*/
    final int DISTANT=50;
    private ActionBar actionBar;

    //tag等于false，即代表底部按钮的背景图片是黑色
    boolean tagFragment0 = false;
    boolean tagFragment1 = false;
    boolean tagFragment2 = false;

    private String TAG="FragmentSwitchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//设置窗口无标题栏
        setContentView(R.layout.activity_fragment_switch);


        Log.i(TAG,"OnCreate");
        //分别实例化和初始化fragement、lineatlayout、textview
        setfragment();
        setlinearLayouts();
        settextview();
        //创建手势检测器
        detector=new GestureDetector(this);
    }

    /**初始化fragment*/
    public void setfragment()
    {
        Log.i(TAG,"setFragment");

        fragments=new Fragment[3];
        fragments[0]=getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragments[1]=getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragments[2]=getSupportFragmentManager().findFragmentById(R.id.fragment3);
        getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                .show(fragments[0]).commit();

    }
    /**初始化linerlayout*/
    public void setlinearLayouts()
    {
        Log.i(TAG,"setlinearLayouts");
        linearLayouts=new LinearLayout[3];
        linearLayouts[0]=(LinearLayout)findViewById(R.id.lay1);
        linearLayouts[1]=(LinearLayout)findViewById(R.id.lay2);
        linearLayouts[2]=(LinearLayout)findViewById(R.id.lay3);
        //linearLayouts[0].setBackgroundResource(R.color.lightseagreen);
    }

    /**初始化textview*/
    public void settextview()
    {
        Log.i(TAG,"settextview");
        textViews=new TextView[3];
        textViews[0]=(TextView)findViewById(R.id.fratext1);
        textViews[1]=(TextView)findViewById(R.id.fratext2);
        textViews[2]=(TextView)findViewById(R.id.fratext3);
        //textViews[0].setTextColor(getResources().getColor(R.color.lightseagreen));
        textViews[0].setBackground(getDrawable(R.drawable.button_gas_blue));
        tagFragment0 = !tagFragment0;
        setTitle(R.string.weatherPage_title);
    }
    /**点击底部linerlayout实现切换fragment的效果*/
    public void LayoutOnclick(View v)
    {

        Log.i(TAG,"LayoutOnclick");
        //resetlaybg();//每次点击都重置linearLayouts的背景、textViews字体颜色
        switch (v.getId()) {
            case R.id.lay1:
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                        .show(fragments[0]).commit();
                //linearLayouts[0].setBackgroundResource(R.drawable.background);
               // textViews[0].setTextColor(getResources().getColor(R.color.lightseagreen));
                //textViews[0].setBackground(getDrawable(R.drawable.button_gas_blue));
                //设置底部按钮的颜色变换，因为当前是fragment0，所以gas button图片背景如果是黑色，则置换为蓝色
                if(tagFragment0 == false){
                    textViews[0].setBackground(getDrawable(R.drawable.button_gas_blue));
                    tagFragment0 = !tagFragment0;

                }

                //若其余两个按钮为蓝色，则置为黑色
                if(tagFragment2 == true){
                    textViews[2].setBackground(getDrawable(R.drawable.button_user_center_black));
                    tagFragment2 = !tagFragment2;

                }
                if(tagFragment1 == true){
                    textViews[1].setBackground(getDrawable(R.drawable.button_sensor_black));
                    tagFragment1 = !tagFragment1;

                }

                setTitle(R.string.weatherPage_title);

                MARK=0;
                break;

            case R.id.lay2:
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                        .show(fragments[1]).commit();
                //linearLayouts[1].setBackgroundResource(R.drawable.background);
                //textViews[1].setTextColor(getResources().getColor(R.color.lightseagreen));
               // textViews[1].setBackground(getDrawable(R.drawable.button_sensor_blue));

                //设置底部按钮的颜色变换，因为当前是fragment1，所以sensor button图片背景如果是黑色，则置换为蓝色
                if(tagFragment1 == false){
                    textViews[1].setBackground(getDrawable(R.drawable.button_sensor_blue));
                    tagFragment1 = !tagFragment1;

                }

                //若其余两个按钮为蓝色，则置为黑色
                if(tagFragment0 == true){
                    textViews[0].setBackground(getDrawable(R.drawable.button_gas_black));
                    tagFragment0 = !tagFragment0;

                }
                if(tagFragment2 == true){
                    textViews[2].setBackground(getDrawable(R.drawable.button_user_center_black));
                    tagFragment2 = !tagFragment2;

                }

                setTitle(R.string.sensorPage_title);
                MARK=1;
                break;
            case R.id.lay3:
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                        .show(fragments[2]).commit();
                //linearLayouts[2].setBackgroundResource(R.drawable.background);
                //textViews[2].setTextColor(getResources().getColor(R.color.lightseagreen));
                //textViews[2].setBackground(getDrawable(R.drawable.button_user_center_blue));

                //设置底部按钮的颜色变换，因为当前是fragment2，所以user center图片背景如果是黑色，则置换为蓝色
                if(tagFragment2 == false){
                    textViews[2].setBackground(getDrawable(R.drawable.button_user_center_blue));
                    tagFragment2 = !tagFragment2;

                }

                //若其余两个按钮为蓝色，则置为黑色
                if(tagFragment0 == true){
                    textViews[0].setBackground(getDrawable(R.drawable.button_gas_black));
                    tagFragment0 = !tagFragment0;

                }
                if(tagFragment1 == true){
                    textViews[1].setBackground(getDrawable(R.drawable.button_sensor_black));
                    tagFragment1 = !tagFragment1;

                }
                setTitle(R.string.user_center_title);
                MARK=2;
                break;
            default:
                break;
        }
    }
    /**重置linearLayouts、textViews*/
    public void resetlaybg()
    {
        Log.i(TAG,"resetlaybg");
        for(int i=0;i<3;i++)
        {
            linearLayouts[i].setBackgroundResource(R.color.lightseagreen);
            textViews[i].setTextColor(getResources().getColor(R.color.black));
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        //将该Activity上触碰事件交给GestureDetector处理
        return detector.onTouchEvent(event);
    }
    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }
    /**滑动切换效果的实现*/
    @Override
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
                           float arg3) {
        // TODO Auto-generated method stub
        Log.i(TAG,"onFling");
        //resetlaybg();
        //当是Fragment0的时候
        if(MARK==0)
        {
            if(arg1.getX()>arg0.getX()+DISTANT)
            {
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                        .show(fragments[1]).commit();
                //linearLayouts[1].setBackgroundResource(R.color.lightseagreen);
                //textViews[1].setTextColor(getResources().getColor(R.color.lightseagreen));
                //设置底部按钮的颜色变换，因为当前是fragment1，所以sensor button图片背景如果是黑色，则置换为蓝色
                if(tagFragment1 == false){
                    textViews[1].setBackground(getDrawable(R.drawable.button_sensor_blue));
                    tagFragment1 = !tagFragment1;
                }

                //若其余两个按钮为蓝色，则置为黑色
                if(tagFragment0 == true){
                    textViews[0].setBackground(getDrawable(R.drawable.button_gas_black));
                    tagFragment0 = !tagFragment0;
                }
                if(tagFragment2 == true){
                    textViews[2].setBackground(getDrawable(R.drawable.button_user_center_black));
                    tagFragment2 = !tagFragment2;
                }

                setTitle(R.string.sensorPage_title);

                MARK=1;
            }

        }
        //当是Fragment1的时候
        else if (MARK==1)
        {
            if(arg1.getX()>arg0.getX()+DISTANT)
            {
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                        .show(fragments[2]).commit();
                //linearLayouts[2].setBackgroundResource(R.color.lightseagreen);
                //textViews[2].setTextColor(getResources().getColor(R.color.lightseagreen));

                //设置底部按钮的颜色变换，因为当前是fragment2，所以user center图片背景如果是黑色，则置换为蓝色
                if(tagFragment2 == false){
                    textViews[2].setBackground(getDrawable(R.drawable.button_user_center_blue));
                    tagFragment2 = !tagFragment2;
                }

                //若其余两个按钮为蓝色，则置为黑色
                if(tagFragment0 == true){
                    textViews[0].setBackground(getDrawable(R.drawable.button_gas_black));
                    tagFragment0 = !tagFragment0;
                }
                if(tagFragment1 == true){
                    textViews[1].setBackground(getDrawable(R.drawable.button_sensor_black));
                    tagFragment1 = !tagFragment1;
                }

                setTitle(R.string.user_center_title);
                MARK=2;
            }
            else if(arg0.getX()>arg1.getX()+DISTANT)
            {
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                        .show(fragments[0]).commit();
                //linearLayouts[0].setBackgroundResource(R.color.lightseagreen);
                //textViews[0].setTextColor(getResources().getColor(R.color.lightseagreen));

                //设置底部按钮的颜色变换，因为当前是fragment0，所以gas button图片背景如果是黑色，则置换为蓝色
                if(tagFragment0 == false){
                    textViews[0].setBackground(getDrawable(R.drawable.button_gas_blue));
                    tagFragment0 = !tagFragment0;
                }

                //若其余两个按钮为蓝色，则置为黑色
                if(tagFragment2 == true){
                    textViews[2].setBackground(getDrawable(R.drawable.button_user_center_black));
                    tagFragment2 = !tagFragment2;
                }
                if(tagFragment1 == true){
                    textViews[1].setBackground(getDrawable(R.drawable.button_sensor_black));
                    tagFragment1 = !tagFragment1;
                }


                setTitle(R.string.weatherPage_title);
                MARK=0;
            }

        }
        //当是Fragment2的时候
        else if(MARK==2)
        {
            if(arg0.getX()>arg1.getX()+DISTANT)
            {
                getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1]).hide(fragments[2])
                        .show(fragments[1]).commit();
                //linearLayouts[1].setBackgroundResource(R.color.black);
                //textViews[1].setTextColor(getResources().getColor(R.color.lightseagreen));

                //设置底部按钮的颜色变换，因为当前是fragment1，所以sensor button图片背景如果是黑色，则置换为蓝色
                if(tagFragment1 == false){
                    textViews[1].setBackground(getDrawable(R.drawable.button_sensor_blue));
                    tagFragment1 = !tagFragment1;
                }

                //若其余两个按钮为蓝色，则置为黑色
                if(tagFragment0 == true){
                    textViews[0].setBackground(getDrawable(R.drawable.button_gas_black));
                    tagFragment0 = !tagFragment0;
                }
                if(tagFragment2 == true){
                    textViews[2].setBackground(getDrawable(R.drawable.button_user_center_black));
                    tagFragment2 = !tagFragment2;
                }
                setTitle(R.string.sensorPage_title);
                MARK=1;
            }

        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
                            float arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }


}
