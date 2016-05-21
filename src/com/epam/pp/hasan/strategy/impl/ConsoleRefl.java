package com.epam.pp.hasan.strategy.impl;

import com.epam.pp.hasan.annotation.ProductAnnotation;
import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.strategy.ProductStrategy;
import com.epam.pp.hasan.util.ConsoleHelper;
import com.epam.pp.hasan.util.Validator;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

/**
 * @author Yosin_Hasan
 */
public class ConsoleRefl implements ProductStrategy {
    private String PROPERTIES_FILE = "lang";

    @Override
    public Product addProduct(Class productClass) {
        if (productClass == null) {
            return null;
        }
        ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE);
        try {
            Class clazz = productClass;
            Object obj = clazz.newInstance();
            while (clazz != Object.class) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method m : methods) {
                    if (m.isAnnotationPresent(ProductAnnotation.class)) {
                        ProductAnnotation ann = m.getAnnotation(ProductAnnotation.class);
                        System.out.println(rb.getString(ann.resource()));
                        Object arg = ConsoleHelper.get(ann.type());
                        if (Validator.isValid(arg, ann.type())) {
                            m.invoke(obj, arg);
                        } else {
                            throw new Exception("Invalid argument");
                        }
                    }
                }
                clazz = clazz.getSuperclass();
            }
            return (Product) obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
