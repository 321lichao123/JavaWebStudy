package com.atgugui.test;

import com.atgugui.pojo.Cart;
import com.atgugui.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName: CartTest
 *
 * @Author: lichao
 * @Date: 2021/12/7
 * @Description:
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Java从入门到放弃", 5, new BigDecimal(100), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "Java从入门到放弃", 5, new BigDecimal(100), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "javascript从入门到放弃", 10, new BigDecimal(100), new BigDecimal(1000)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Java从入门到放弃", 5, new BigDecimal(100), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "Java从入门到放弃", 5, new BigDecimal(100), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "javascript从入门到放弃", 10, new BigDecimal(100), new BigDecimal(1000)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Java从入门到放弃", 5, new BigDecimal(100), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "Java从入门到放弃", 5, new BigDecimal(100), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "javascript从入门到放弃", 10, new BigDecimal(100), new BigDecimal(1000)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "Java从入门到放弃", 5, new BigDecimal(100), new BigDecimal(500)));
        cart.addItem(new CartItem(1, "Java从入门到放弃", 5, new BigDecimal(100), new BigDecimal(500)));
        cart.addItem(new CartItem(2, "javascript从入门到放弃", 10, new BigDecimal(100), new BigDecimal(1000)));
        cart.updateCount(2, 20);
        System.out.println(cart);
    }
}