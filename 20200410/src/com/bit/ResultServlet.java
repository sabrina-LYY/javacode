package com.bit;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultServlet extends HttpServlet {
    private DataSource dataSource;
    {
        MysqlDataSource mysqlDataSource = new MysqlDataSource() ;
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("");
        mysqlDataSource.setDatabaseName("java20_0410");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");

        dataSource=mysqlDataSource;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从QueryString中获取用户想要查的单词
        String word = req.getParameter("word");

        //准备响应内容格式（以http响应头的形式输出）
        resp.setContentType("text/html;charset = utf-8");
        PrintWriter writer = resp.getWriter();
        //2.从数据中查询需要的结果
        try(Connection con =  dataSource.getConnection()){
            String sql = "SELECT zh,sentence FROM dictionaries WHERE en = ?";
            try(PreparedStatement stmt = con.prepareStatement(sql)){
                stmt.setString(1,word);
                try(ResultSet rs = stmt.executeQuery()){
                    //只有两种结果：返回一行或没有返回
                    if(rs.next()){
                        //返回一行
                        String zh = rs.getString("zh");
                        String sentence = rs.getString("sentence");

                        writer.println("<h1>"+word+"</h1>");
                        writer.println("<p>"+zh+"</p>");
                        writer.println("<p>例句"+sentence+"</p>");


                    }else{
                        //没有返回
                        writer.println("<h1>查不到该单词："+word+"</h1>");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();//把异常信息大隐刀控制台
            writer.println("<h1>错误</h1>");//把错误信息输入出到浏览器上
            writer.println("<p>"+e.getMessage()+"</p>");
        }

    }
}
