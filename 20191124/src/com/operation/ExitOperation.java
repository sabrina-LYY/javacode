package com.operation;

import com.book.BookList;

public class ExitOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");


    }
}
