package com.lyy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        req.setCharacterEncoding("UTF-8");
        String target = req.getParameter("target");
        if(target==null){
            target="世界";
        }
        resp.setContentType("text/html;charset = utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>你好"+target+"</h2>");

    }
}
