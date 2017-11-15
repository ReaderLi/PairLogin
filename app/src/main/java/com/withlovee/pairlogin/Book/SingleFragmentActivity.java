package com.withlovee.pairlogin.Book;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.withlovee.pairlogin.R;

/**
 * Created by LRD on 2017/5/23.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {

    //为了实例化新的fragment,新增createFragment方法，
    // 子类会实现该方法来返回由activity托管的fragment实例
    protected abstract Fragment createFragment();

    private String TAG="SingleFragmentActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        Log.i(TAG,"onCreate");
        /**
         *
         * 设备旋转或回收内存时，Android
         会销毁 CrimeActivity， 而后重建时，会调用 CrimeActivity.onCreate(...) 方法。activity被
         销毁时，它的 FragmentManager 会将fragment队列保存下来。这样，activity重建时，新的
         FragmentManager 会首先获取保存的队列，然后重建fragment队列，从而恢复到原来的状态。
         */
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = createFragment();

            //创建并提交了一个fragment事物
            //创建一个新的fragment事务，加入一个添加操作，然后提交该事务。
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
