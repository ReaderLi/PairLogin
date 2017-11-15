package com.withlovee.pairlogin.Book;

import android.support.v4.app.Fragment;

/**
 * Created by LRD on 2017/5/24.
 */

public class BookListActivity extends SingleFragmentActivity{


    @Override
    protected Fragment createFragment() {
        return new BookListFragment();
    }


}
