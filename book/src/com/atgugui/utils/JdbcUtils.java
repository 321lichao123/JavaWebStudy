package com.atgugui.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: JdbcUtils
 *
 * @Author: lichao
 * @Date: 2021/11/21
 * @Description:
 */
public class JdbcUtils {

    private static DruidDataSource source;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    // 使用静态代码块进行初始化
    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            source = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * Description: 获取数据库连接池中的链接<br/>
    * @author: 12468<br/>
    * @date: 2021/11/21 21:33<br/>
    * @param:<br/>
    * @return:
    */
    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn == null) {
            try {
                conn = source.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
        /*Connection conn = null;
        try {
            conn = source.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;*/
    }

    public static void commitAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则会出错(因为tomcat服务器底层使用了线程池技术)
        conns.remove();
    }

    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则会出错(因为tomcat服务器底层使用了线程池技术)
        conns.remove();
    }

    /**
    * Description: 关闭链接，将链接放回数据库中<br/>
    * @author: 12468<br/>
    * @date: 2021/11/21 21:34<br/>
    * @param:<br/>
    * @return:

    public static void close(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
