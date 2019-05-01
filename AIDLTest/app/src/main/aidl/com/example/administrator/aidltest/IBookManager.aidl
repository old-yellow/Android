// IBookManager.aidl
package com.example.administrator.aidltest;

import com.example.administrator.aidltest.Book;
import com.example.administrator.aidltest.IOnNewBookArrivedListener;
interface IBookManager {

    List<Book> getBookList();

    void addBook(in Book book);

    void registerListener(IOnNewBookArrivedListener listener);

    void unregisterListener(IOnNewBookArrivedListener listener);

}
