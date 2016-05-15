package com.epam.pp.hasan.facade.repository.basket;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.epam.pp.hasan.utils.Date;

/**
 * @author Yosin_Hasan
 */
public class BasketRepositoryImpl implements BasketRepository {
    private HashMap<Integer, Integer> data;
    private LinkedHashMap<Long, Integer> top;

    /**
     *
     */
    public BasketRepositoryImpl() {
        data = new HashMap<Integer, Integer>();
        top = new LinkedHashMap<Long, Integer>();
    }

    @Override
    public Boolean addProduct(Integer id, Integer amount) {
        if (id >= 0 && amount > 0) {
            top.put(Date.getCurrentTime(), id);
            data.put(id, amount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeProduct(Integer id) {
        if (data.containsKey(id)) {
            data.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateProduct(Integer id, Integer amount) {
        if (data.containsKey(id)) {
            data.put(id, amount);
            return true;
        }
        return false;
    }

    @Override
    public HashMap<Integer, Integer> findAll() {
        return data;
    }

    @Override
    public LinkedHashMap<Long, Integer> findTopProducts() {
        return top;
    }

    @Override
    public Boolean removeAll() {
        data.clear();
        return true;
    }
}
