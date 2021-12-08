package com.atgugui.dao.impl;

import com.atgugui.dao.OrderItemDao;
import com.atgugui.pojo.OrderItem;

public class OrderItemImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`, `price`, `total_money`, `count`, `order_id`) values(?, ?, ?, ?, ?)";
        return update(sql, orderItem.getName(), orderItem.getPrice(), orderItem.getTotalMoney(), orderItem.getCount(), orderItem.getOrderId());
    }
}
