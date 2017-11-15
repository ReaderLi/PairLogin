package com.withlovee.pairlogin.Book;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.UUID;

/**
 * Created by LRD on 2017/5/24.
 */

public class BookActivity extends SingleFragmentActivity{

    private String TAG="BookActivity";

    private static final String EXTRA_BOOK_ID =
            "com.bignerdranch.android.criminalintent.crime_id";


    public static Intent newIntent(Context packageContext, UUID crimeId) {

        Intent intent = new Intent(packageContext, BookActivity.class);
        intent.putExtra(EXTRA_BOOK_ID, crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        Log.i(TAG,"createFragment()");

        //return new CrimeFragment();

        /**
         *  CrimeActivity 必须了解
         CrimeFragment 的内部细节，比如知道它内部有个 newInstance(UUID) 方法。这很正常。托管
         activity应该知道这些细节，以便托管fragment；但fragment就不一定要知道其托管activity的细节
         问题，至少在需要保持fragment通用独立性的时候是如此。
         *
         */
        UUID bookId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_BOOK_ID);
        return BookFragment.newInstance(bookId);
    }
}
