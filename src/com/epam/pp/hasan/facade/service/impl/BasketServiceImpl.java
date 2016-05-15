package com.epam.pp.hasan.facade.service.impl;

import com.epam.pp.hasan.facade.repository.basket.BasketRepository;
import com.epam.pp.hasan.facade.service.BasketService;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Yosin_Hasan on 5/12/2016.
 */
public class BasketServiceImpl implements BasketService {
    private BasketRepository basketRep;

    /**
     *
     * @param basketRep basket repository
     */
    public BasketServiceImpl(BasketRepository basketRep) {
        this.basketRep = basketRep;
    }

    @Override
    public Boolean addProduct(Integer id, Integer amount) {
        return basketRep.addProduct(id, amount);
    }

    @Override
    public Boolean removeProduct(Integer id) {
        return basketRep.removeProduct(id);
    }

    @Override
    public Boolean updateProduct(Integer id, Integer amount) {
        return basketRep.updateProduct(id, amount);
    }

    @Override
    public HashMap<Integer, Integer> findAll() {
        return basketRep.findAll();
    }

    @Override
    public LinkedHashMap<Long, Integer> findTopProducts() {
        return basketRep.findTopProducts();
    }

    @Override
    public Boolean removeAll() {
        return basketRep.removeAll();
    }
}
