package com.withlovee.pairlogin.Book;

import java.util.UUID;

/**
 * Created by LRD on 2017/5/24.
 */

public class Book {

    //书籍的ISBN，类型，押金，索书号
    private UUID mId;
    private String isbn;
    private String type;
    private String pledgeCash;
    private String callNumber;

    public Book() {
        mId = UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getType() {
        return type;
    }

    public String getPledgeCash() {
        return pledgeCash;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPledgeCash(String pledgeCash) {
        this.pledgeCash = pledgeCash;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }
}
