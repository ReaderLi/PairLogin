package com.withlovee.pairlogin.Book;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.withlovee.pairlogin.R;

import java.util.UUID;

/**
 * Created by LRD on 2017/5/24.
 */

public class BookFragment extends Fragment {

    private static final String ARG_BOOK_ID = "book_id";

    private Book mBook;
    private EditText mIsbnET;
    private EditText mTypeET;
    private EditText mPledgeCashET;
    private EditText mCallNumberET;

    private String TAG = " BookFragment";

    //要附加argument bundle给fragment，需调用 Fragment.setArguments(Bundle) 方法。而且，
    //还必须在fragment创建后、添加给activity前完成。
    public static BookFragment newInstance(UUID bookId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_BOOK_ID, bookId);

        BookFragment fragment = new BookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mCrime = new Crime();
        /*UUID crimeId = (UUID) getActivity().getIntent()
                .getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);*/

        UUID bookId = (UUID) getArguments().getSerializable(ARG_BOOK_ID);

        mBook = BookLab.get(getActivity()).getBook(bookId);

        Log.i(TAG,"onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book, container, false);

        mIsbnET = (EditText)v.findViewById(R.id.book_isbn);
        mIsbnET.setText(mBook.getIsbn());
        mIsbnET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mBook.setIsbn(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }

        });


        mTypeET = (EditText)v.findViewById(R.id.book_type);
        mTypeET.setText(mBook.getType());
        mTypeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mBook.setType(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }

        });

        mPledgeCashET = (EditText)v.findViewById(R.id.book_pledgeCash);
        mPledgeCashET.setText(mBook.getPledgeCash());
        mPledgeCashET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mBook.setPledgeCash(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }

        });

        mCallNumberET = (EditText)v.findViewById(R.id.book_callNumber);
        mCallNumberET.setText(mBook.getCallNumber());
        mCallNumberET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mBook.setCallNumber(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }

        });

        Log.i(TAG,"onCreateView");
        return v;
    }




}
