package com.lyy;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

    private static volatile DataSource dataSource = null;
    public static Connection getConnection() throws SQLException{
        if(dataSource==null){
            synchronized (DBUtil.class){
                if(dataSource==null){
                    dataSource=initDataSource();
                }
            }
        }
        return dataSource.getConnection();
    }

    private static DataSource initDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setPort(3306);
        dataSource.setServerName("127.0.0.1");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setDatabaseName("java_0520");
        dataSource.setUseSSL(false);

        return dataSource;

    }
}
