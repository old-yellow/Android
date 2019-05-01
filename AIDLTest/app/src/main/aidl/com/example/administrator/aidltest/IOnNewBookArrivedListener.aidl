// IOnNewBookArrivedListener.aidl
package com.example.administrator.aidltest;

import com.example.administrator.aidltest.Book;
interface IOnNewBookArrivedListener {

    void onNewBookArrived(in Book newBook);
}
