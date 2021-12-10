package com.atgugui.service.impl;

import com.atgugui.dao.BookDao;
import com.atgugui.dao.OrderDao;
import com.atgugui.dao.OrderItemDao;
import com.atgugui.dao.impl.BookDaoImpl;
import com.atgugui.dao.impl.OrderDaoImpl;
import com.atgugui.dao.impl.OrderItemImpl;
import com.atgugui.pojo.*;
import com.atgugui.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrderId(Cart cart, Integer userId) {
        // 1、生成订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        // 2、生成Order订单
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        // 3、保存订单
        orderDao.saveOrder(order);
        // 模拟异常
        Integer i =  12 / 0;

        // 4、生成订单项
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getPrice(), cartItem.getTotalPrice(), cartItem.getCount(), orderId);
            orderItemDao.saveOrderItem(orderItem);

            // 生成的订单删除库存和增加销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        // 5、清空菜单
        cart.clear();
        return orderId;
    }
}
