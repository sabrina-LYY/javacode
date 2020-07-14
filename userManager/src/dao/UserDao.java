package dao;

import entity.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public static User login(User loginUser){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        String sql = "SELECT * FROM usermessage where username=? and password=?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1,loginUser.getUsername());
            ps.setString(2,loginUser.getPassword());

            rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getString("address"));
                user.setQq(rs.getString("qq"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(con,ps,rs);
        }
        return user;
    }

    public static int add(User user){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String sql = "insert into usermessage(name, username, password, gender, age, address, qq, email) values(?,?,?,?,?,?,?,?)";
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1,user.getName());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getGender());
            ps.setInt(5,user.getAge());
            ps.setString(6,user.getAddress());
            ps.setString(7,user.getQq());
            ps.setString(8,user.getEmail());

            int ret=ps.executeUpdate();
            return ret;//如果返回0，表示失败
        }catch  (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(con,ps,rs);
        }
        return 0;//添加失败
    }


    //按照id删除
    public static int delete(int id){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete from usermessage where id=?";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1,id);
            int ret = ps.executeUpdate();//返回值是整数
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBUtil.close(con,ps,rs);
        }
        return 0;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("zhangfei");
        user.setPassword("123");
        if(login(user)==null){
            System.out.println("登陆失败");
        }else{
            System.out.println("登录成功");
        }
    }
}
