package com.atgugui.dao.impl;

import com.atgugui.dao.OrderDao;
import com.atgugui.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`, `create_time`, `total_money`, `status`, `user_id`) value(?, ?, ?, ?, ?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getTotalMoney(), order.getStatus(), order.getUserId());
    }
}
