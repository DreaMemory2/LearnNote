package com.crystal.javaweb.client;

import jakarta.servlet.annotation.WebServlet;

import java.util.Arrays;

/**
 * @author Crystal
 * @version 1.0
 * @since 1.0
 */
public class AnnotationServletTest {

    public static void main(String[] args) throws Exception {
        // 使用反射机制将类上上面注解进行解析
        // 获取CLass对象
        Class<?> clazz = Class.forName("com.crystal.javaweb.servlet.AnnotationServlet");

        // 获取这个类上面的注解
        // 先判断这个类是否有这个注解对象，如果有则获取这个对象
        if (clazz.isAnnotationPresent(WebServlet.class)) {
            WebServlet annotation = clazz.getAnnotation(WebServlet.class);

            System.out.println(annotation.name());
            System.out.println(Arrays.toString(annotation.urlPatterns()));
        }
    }
}
