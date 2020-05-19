package Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Goods;
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
import java.util.*;

@WebServlet("/goods")
public class GoodsBrowseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("浏览商品！");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //找到数据，然后打包，json字符串形式传到前端
        //1.先从数据库找到所有的商品信息
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //把每行的商品存到list中
        List<Goods> goodsList = new ArrayList<>();

        try{
            String sql = "select id,name,introduce,stock,unit,price,discount from goods";
            connection = DButil.getConnection(true);
            ps = connection.prepareStatement(sql);
            //查询到的结果保存在rs中
            rs = ps.executeQuery();
            while(rs.next()){
                //查询到的东西都在next中
                //不为空，将属性取出放进goodslist中
                Goods goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("name"));
                goods.setIntroduce(rs.getString("introduce"));
                goods.setStock(rs.getInt("stock"));
                goods.setUnit(rs.getString("unit"));
                goods.setPrice(rs.getInt("price"));
                goods.setDiscount(rs.getInt("discount"));
                goodsList.add(goods);

            }
            System.out.println("商品列表");
            System.out.println(goodsList);


            //将后端的数据(goodsList中的数据)转换为JSON字符串
            ObjectMapper objectMapper = new ObjectMapper();
            Writer writer = resp.getWriter();
            //将goodsList转换为JSON字符串，并将该字符串写入流中
            objectMapper.writeValue(writer,goodsList);
            //推到前端
            writer.write(writer.toString());

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DButil.close(connection,ps,rs);
        }

    }
}
