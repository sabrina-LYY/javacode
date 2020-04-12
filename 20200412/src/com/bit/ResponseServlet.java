package com.bit;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response-demo")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //影响HTTP响应状态的API
        //resp.setStatus(404);
        //resp.sendError(404,"天气晴朗");//setStatus+填充正文
        //resp.sendRedirect("/");//setStatus+setHeader("Location")

        //设置HTTP响应头
        //resp.setHeader("Key","Value");
        //resp.setHeader("Content-Type","zhangsan");
        //resp.setHeader("Content-Type","text/html:charset=utf-8");

        //等价于上一句
        //resp.setContentType("text/html;charset=utf-8");//等价于setHeader("Content-Type","")

       //等价于上一句
        /*resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");


        resp.setIntHeader("Key",18);
        resp.setHeader("Key",String.valueOf(18));
        */

        //填充正文信息
        //文本文件
        /*
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("你好世界");
        writer.println("今天天气好");
        */

        //图片
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        ServletOutputStream outputStream = resp.getOutputStream();
        //写一个“你”
        outputStream.write(0x14);
        outputStream.write(0xBD);
        outputStream.write(0xA0);
    }

}
