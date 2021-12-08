package com.atgugui.service;

import com.atgugui.pojo.Cart;

public interface OrderService {
    public String createOrderId(Cart cart, Integer userId);
}
