package util;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {

    private static final String URL= "jdbc:mysql://localhost:3306/cash?useSSL=false";
    private static final String USERNAME= "root";
    private static final String PASSWORD= "";

    private static volatile DataSource DATASOURCE;

    //数据库连接池
    private static DataSource getDATASOURCE(){
        if(DATASOURCE == null){//单例模式
            synchronized (DButil.class){//获取这把锁
                if(DATASOURCE==null){
                    DATASOURCE = new MysqlDataSource();
                    ((MysqlDataSource) DATASOURCE).setURL(URL);
                    ((MysqlDataSource) DATASOURCE).setUser(USERNAME);
                    ((MysqlDataSource) DATASOURCE).setPassword(PASSWORD);

                }
            }
        }

        return DATASOURCE;
    }
    //autocommit为真，如果插入失败，仍然插入进去了，如果为假（手动提交），整体插入完成执行comit才能提交
    //批量插入用手动提交
    public static Connection getConnection(boolean autocommit){

        try {
            Connection connection = getDATASOURCE().getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs){

            try {
                if(rs!=null){
                rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}

