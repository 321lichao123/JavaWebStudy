package com.atgugui.dao.impl;

import com.atgugui.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: BaseDao
 *
 * @Author: lichao
 * @Date: 2021/11/21
 * @Description:
 */
public abstract class BaseDao {
    // 使用dbutils操作数据库
    private QueryRunner queryRunner = new QueryRunner();
    /**
    * Description: update方法用于来执行：insert、update、delete语句<br/>
    * @author: 12468<br/>
    * @date: 2021/11/21 22:10<br/>
    */
    public int update(String sql, Object ...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
    * Description: 查询一条JavaBean的sql语句<br/>
    * @author: 12468<br/>
    * @date: 2021/11/21 22:16<br/>
    * @param:<br/>
    * @return:
    */
    public <T>T queryForOne(Class<T> type, String sql, Object ...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
    * Description: 查询返回多个javabean<br/>
    * @author: 12468<br/>
    * @date: 2021/11/21 22:20<br/>
    * @param:<br/>
    * @return:
    */
    public <T>List<T> queryForList(Class<T> type, String sql, Object ...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
    * Description: 返回一行一列的sql语句<br/>
    * @author: 12468<br/>
    * @date: 2021/11/21 22:23<br/>
    * @param:<br/>
    * @return:
    */
    public Object queryForSingValue(String sql, Object ...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }
}
