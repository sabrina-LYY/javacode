package Servlet;

import util.DButil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注册！");

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Connection connection = null;
        PreparedStatement ps = null;

        //servlet的输出流，在前端页面可以直接显示和解析
        Writer writer = resp.getWriter();
        try {
            String sql = " INSERT INTO account(username,password) VALUES(?,?)";
            //获取连接,true表示自动插入
            connection = DButil.getConnection(true);

            //connection中的prepareStatement方法可以预编译sql语句
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);

            int ret = ps.executeUpdate();//返回如果是0则插入失败，返回数字表示插入成功
            if(ret==0){
                System.out.println("注册失败！");
              //将内容写到页面上
                writer.write("<h2>注册失败</h2>");
            }else{
                System.out.println("注册成功！");
                writer.write("<h2>注册成功</h2>");

                //要跳转的页面
                resp.sendRedirect("login.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //关闭打开的资源
            DButil.close(connection,ps,null);
        }

    }



}
