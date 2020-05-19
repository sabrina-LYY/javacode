package Servlet;

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

@WebServlet("/inbound")
public class GoodsPutAwayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("上架商品");

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset = utf-8");

        //获取参数
        String name = req.getParameter("name");
        String stock = req.getParameter("stock");
        String introduce = req.getParameter("introduce");
        String unit = req.getParameter("unit");

        String price = req.getParameter("price");
        double doublePrice = Double.valueOf(price);//89.9
        int realPrice = new Double(100*doublePrice).intValue();//8990

        String discount = req.getParameter("discount");

        Connection connection = null;
        PreparedStatement ps = null;


        Writer writer = resp.getWriter();
        try {
            String sql ="insert into goods(name,introduce,stock,unit,price,discount) values(?,?,?,?,?,?)";
            connection = DButil.getConnection(true);
            ps = connection.prepareStatement(sql);

            //赋值
            ps.setString(1,name);
            ps.setString(2,introduce);
            ps.setInt(3,Integer.valueOf(stock));
            ps.setString(4,unit);
            ps.setInt(5,realPrice);
            ps.setInt(6,Integer.valueOf(discount));

            int ret = ps.executeUpdate();
            if(ret==0){
                System.out.println("上架失败！");
                writer.write("<h2>上架失败</h2>");
            }else{
                System.out.println("上架成功");
                writer.write("<h2>上架成功</h2>");
                resp.sendRedirect("index.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DButil.close(connection,ps,null);
        }
    }
}
