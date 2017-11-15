package com.withlovee.pairlogin.Book;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.withlovee.pairlogin.R;

import java.util.List;

/**
 * Created by LRD on 2017/5/24.
 */

public class BookListFragment extends Fragment {

    private RecyclerView mBookRecyclerView;
    private BookAdapter mAdapter;

    private String TAG="BookListFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.test, container, false);

        mBookRecyclerView = (RecyclerView) view
                .findViewById(R.id.book_recycler_view);

        //没有 LayoutManager 的支持，不仅 RecyclerView 无法工作，还会导致应用崩溃。所
        //以， RecyclerView 视图创建完成后，就立即转交给了 LayoutManager 对象
        mBookRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }


    //当用户点击列表项进行修改并返回时，更新内容
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){
        BookLab crimeLab = BookLab.get(getActivity());
        List<Book> crimes = crimeLab.getBooks();

        if (mAdapter == null) {
            mAdapter = new BookAdapter(crimes);
            mBookRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }



    private class BookHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        //public TextView mTitleTextView;

        private TextView mISBNTextView;
        private TextView mTypeTextView;
        private TextView mPledgeCashTextView;
        private TextView mCallNumberTextView;


        private Book mBook;

        //传入的itemView必须是textView
        public BookHolder(View itemView) {
            super(itemView);
            //mTitleTextView = (TextView) itemView;
            itemView.setOnClickListener(this);

            mISBNTextView = (TextView)
                    itemView.findViewById(R.id.list_item_book_isbn_textView);
            mTypeTextView = (TextView)
                    itemView.findViewById(R.id.list_item_book_type_textView);
            mPledgeCashTextView = (TextView)
                    itemView.findViewById(R.id.list_item_book_pledgeCash_textView);
            mCallNumberTextView = (TextView)
                    itemView.findViewById(R.id.list_item_book_callNumber_textView);

        }

        public void bindCrime(Book book) {
            mBook = book;
            mISBNTextView.setText(mBook.getIsbn());
            mTypeTextView.setText(mBook.getType());
            mPledgeCashTextView.setText(mBook.getPledgeCash());
            mCallNumberTextView.setText(mBook.getCallNumber());
        }

        @Override
        public void onClick(View v) {
           /* Toast.makeText(getActivity(),
                    mCrime.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                    .show();*/

            //Intent intent = new Intent(getActivity(), CrimeActivity.class);
            Intent intent = BookActivity.newIntent(getActivity(), mBook.getmId());
            startActivity(intent);
        }
    }

    private class BookAdapter extends RecyclerView.Adapter<BookHolder> {
        private List<Book> mBooks;

        public BookAdapter(List<Book> books) {
            mBooks = books;
        }

        //创建view视图，然后封装到viewHolder中，此时recyclerView并不要求封装视图加载数据
        //为了得到view视图，实例化了simple_list_item_1的布局
        @Override
        public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_book, parent, false);
            return new BookHolder(view);
        }

        //将viewHolder的view视图和模型层数据绑定起来，
        // 接收到viewHolder和数据索引位置之后，通过索引位置找到要显示的数据进行绑定，绑定完毕，刷新显示视图
        @Override
        public void onBindViewHolder(BookHolder holder, int position) {
            Book book = mBooks.get(position);
            // holder.mTitleTextView.setText(crime.getTitle());
            holder.bindCrime(book);
        }

        //继承adapter必须要实现的抽象方法
        @Override
        public int getItemCount() {
            return mBooks.size();
        }
    }

}
