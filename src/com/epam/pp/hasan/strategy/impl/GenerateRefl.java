package com.epam.pp.hasan.strategy.impl;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.epam.pp.hasan.annotation.ProductAnnotation;
import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.strategy.ProductStrategy;

/**
 * @author Yosin_Hasan
 */
public class GenerateRefl implements ProductStrategy {
    @Override
    public Product addProduct(Class productClass) {
        if (productClass == null) {
            return null;
        }
        try {
            Class clazz = productClass;
            Object obj = clazz.newInstance();
            while (clazz != Object.class) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method m : methods) {
                    if (m.isAnnotationPresent(ProductAnnotation.class)) {
                        ProductAnnotation ann = m.getAnnotation(ProductAnnotation.class);
                        Object arg = generateObject(ann.type());
                        m.invoke(obj, arg);
                    }
                }
                clazz = clazz.getSuperclass();
            }
            return (Product) obj;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private Object generateObject(String type) {
        Object input = null;
        if (type.contains("Integer")) {
            input = (int) (Math.random() * 10000);
            return input;
        }
        if (type.contains("Double")) {
            input = Math.random() * 100000;
            return input;
        }
        if (type.contains("String") || type.contains("Text")) {
            input = "Product text " + Math.random() * 1000;
            return input;
        }
        return input;
    }

}
