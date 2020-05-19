package Servlet;

import entity.Account;
import util.DButil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("登录！");

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //登录要从请求体中 拿到名字和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Writer writer = resp.getWriter();
        try {
            String sql = "select id,username,password from account where username=?and password=?";
            //获取连接
            connection = DButil.getConnection(true);
           //预编译
            ps = connection.prepareStatement(sql);

            //给sql中的占位符赋值
            ps.setString(1,username);
            ps.setString(2,password);

            rs = ps.executeQuery();
            Account user = new Account();
            if(rs.next()){
                //拿到id列的数据
                Integer id = rs.getInt("id");
                user.setId(id);
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

            }
            if(user.getId()==null){
                writer.write("<h2>没有该用户："+username+"</h2>");
            }else if(!password.equals(user.getPassword())){
                writer.write("<h2>密码有误："+username+"</h2>");
            }else{
                //如果登录成功就要记录到SESSION中，因为记录下以后要用
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                writer.write("<h2>登陆成功："+username+"</h2>");
                resp.sendRedirect("index.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DButil.close(connection,ps,rs);
        }

    }
}
