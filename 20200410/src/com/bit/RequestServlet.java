package com.bit;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/request-demo")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<table border = '1'>");
        writer.println("<thread>");
        writer.println("<tr>");
        writer.println("<th>");
        writer.println("方法名");
        writer.println("</th>");
        writer.println("<th>");
        writer.println("结果");
        writer.println("</th>");
        writer.println("<th>");
        writer.println("解释");
        writer.println("</th>");
        writer.println("</tr>");
        writer.println("</thread>");
        writer.println("<tbody>");
        {
            String name = "req.getMethod()";
            String value = req.getMethod();
            String explain = "获取HTTP请求中的方法";
            printTableLine(writer, value,explain,name);


        }

        {
            String name = "req.getRequestURI()";
            String value = req.getRequestURI();
            String explain = "获取HTTP中的URL部分";

            printTableLine(writer,value,explain,name);

        }
        {
            String name = "req.getContextPath()";
            String value = req.getContextPath();
            String explain = "获取URL的Context Path部分";

            printTableLine(writer,value,explain,name);

        }

        {
            String name = "req.getProtocol()";
            String value = req.getProtocol();
            String explain = "获取请求中的HTTP版本部分";

            printTableLine(writer,value,explain,name);

        }
        {
            String name = "req.getParameter(\"name\")";
            String value = req.getParameter("name");
            String explain = "获取URL的QueryString部分,key为name的值";

            printTableLine(writer,value,explain,name);

        }
        {
            String name = "req.getParameter(\"age\")";
            String value = req.getParameter("age");
            String explain = "获取URL的QueryString部分,key为age的值";

            printTableLine(writer,value,explain,name);

        }
        {
            String name = "req.getHeader(\"User-Agent\")";
            String value = req.getHeader("User-Agent");
            String explain = "获取请求头中key为User-Agent的值";

            printTableLine(writer,value,explain,name);

        }
        {
            //理论上还可以获取请求体部分
            //get方法不允许有请求体
            ServletInputStream inputStream = req.getInputStream();
            InputStream is = inputStream;
        }
        writer.println("</tbody>");

        writer.println("</table>");


    }

    private void printTableLine(PrintWriter writer,String value,String explain, String name) {

        writer.println("<tr>");
        writer.println("<td>");
        writer.println(name);
        writer.println("</td>");
        writer.println("<td>");
        writer.println(value);
        writer.println("</td>");
        writer.println("<td>");
        writer.println(explain);
        writer.println("</td>");
        writer.println("</tr>");
    }

}

