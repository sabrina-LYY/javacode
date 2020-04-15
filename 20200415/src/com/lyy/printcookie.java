package com.lyy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print-cookie")
public class printcookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //手动从请求头中获取
        String cookie = req.getHeader("Cookie");
        if(cookie==null){
            System.out.println("没有设置cookie");
            writer.println("没有设置cookie");
        }else{
            System.out.println(cookie);
        }
    }
}
