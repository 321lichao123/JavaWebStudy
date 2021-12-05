package com.atgugui.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * ClassName: WebUtils
 *
 * @Author: lichao
 * @Date: 2021/11/29
 * @Description:
 */
public class WebUtils {
    public static <T>T copyParamToBean(Map value, T bean) {
        try {
            System.out.println("注入之前：" + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
