package com.withlovee.pairlogin.Book;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by LRD on 2017/5/24.
 */

public class BookLab {
    private static BookLab sBookLab;
    private List<Book> mBooks;

    public static BookLab get(Context context){

        if(sBookLab == null){
            sBookLab = new BookLab(context);
        }

        return sBookLab;

    }

    private BookLab(Context context){
        mBooks = new ArrayList<>();
        for (int i=0;i < 100;i++){
            Book book = new Book();
            book.setIsbn("书籍ISBN201756#"+i);
            book.setType("书籍类型type#"+i);
            book.setPledgeCash("书籍押金100#+"+i);
            book.setCallNumber("书籍索书号JK13#+"+i);
            mBooks.add(book);
        }

    }
    public List<Book> getBooks(){
        return mBooks;
    }

    public Book getBook(UUID id){
        for (Book book:mBooks){
            if(book.getmId().equals(id)){
                return book;
            }
        }
        return null;
    }
}
