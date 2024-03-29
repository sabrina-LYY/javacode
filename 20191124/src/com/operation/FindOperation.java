package com.operation;


import com.book.Book;
import com.book.BookList;

public class FindOperation  implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍");
        System.out.println("输入要查找的书名");
        String name = scan.next();
        int i = 0;
        Book book = null;
        for(;i<bookList.getUsedSize();i++){
            book = bookList.getBook(i);
            if((book).getName().equals(name)){
                break;
            }
        }
        if(i==bookList.getUsedSize()){
            System.out.println("没找到");
            return;
        }
        book = bookList.getBook(i);
        System.out.println(book);
        System.out.println("找到了");
    }
}
