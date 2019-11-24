package com;
import com.book.BookList;
import com.user.Admin;
import com.user.NormalUser;
import com.user.User;

import java.util.Scanner;
public class Main {
    public static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("输入你的身份：1.管理员，0.普通用户");
        int who = scanner.nextInt();
        if(who == 1){
            return new Admin(name);
        }else{
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        //准备书籍
        BookList bookList = new BookList();
        //登录返回对象
        User user = login();
        int choice = user.menu();
        //对应操作
        user.doOperation(choice,bookList);
    }
}
