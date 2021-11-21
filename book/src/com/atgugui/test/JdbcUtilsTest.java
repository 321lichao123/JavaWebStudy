package com.atgugui.test;

import com.atgugui.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * ClassName: JdbcUtilsTest
 *
 * @Author: lichao
 * @Date: 2021/11/21
 * @Description:
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }
    }
}
