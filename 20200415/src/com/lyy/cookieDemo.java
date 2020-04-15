package com.lyy;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

@WebServlet("/set-cookie")
public class cookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //手动设置状态位
        //resp.setHeader("Set-Cookie","mingzi=zhangsan");

        //通过cookie对象设置
        Cookie cookie = new Cookie("mingzi","zhangsan");
        resp.addCookie(cookie);
    }
}
