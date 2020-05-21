package com.lyy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection con = DBUtil.getConnection()){
            String sql = "select message from tbl_messages";
            try(PreparedStatement ps = con.prepareStatement(sql)){
                try(ResultSet rs = ps.executeQuery()){
                    resp.setContentType("text/plain;charset = utf-8");
                    PrintWriter writer = resp.getWriter();
                    while(rs.next()){
                        writer.println(rs.getString("message"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset = utf-8");

        String message = req.getParameter("message");

        PrintWriter writer = resp.getWriter();
        try(Connection con = DBUtil.getConnection()) {
            String sql = "insert into tbl_messages(message) values(?)";
            try(PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1,message);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.println("<h2>插入消息成功</h2>");
    }
}
