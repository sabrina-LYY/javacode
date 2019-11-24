package com.operation;

import com.book.BookList;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书：");
        System.out.println("请输入图书的名字");
        String name = scan.next();
        System.out.println("请输入图书的作者");
        String author = scan.next();
        System.out.println("请输入图书的价格");
        int price = scan.nextInt();
        System.out.println("请输入图书的类型");
        String type = scan.next();
        System.out.println("");
    }

}
