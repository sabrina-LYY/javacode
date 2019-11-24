package com.operation;

import com.book.Book;
import com.book.BookList;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        System.out.println("请输入要查找的书名");
        String name = scan.next();
        int i = 0;
        Book book = null;
        //遍历bookList数组
        for(;i<bookList.getUsedSize();i++){
            book = bookList.getBook(i);
            if((book).getName().equals(name)){
                break;
            }
        }

        if(i == bookList.getUsedSize()){
            System.out.println("没有此书");
            return;
        }

        //i号下标书籍就是要删除的书籍
        for(int j = i;j< bookList.getUsedSize()-1;j++){
            //后一个覆盖前一个
            bookList.getBook(j+1);
            bookList.setBook(j,book);//setBook用来设置新的值；
        }
    }
}
