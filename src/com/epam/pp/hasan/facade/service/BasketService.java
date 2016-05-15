package com.epam.pp.hasan.facade.service;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Yosin_Hasan on 5/12/2016.
 */
public interface BasketService {
    /**
     * Add product to basket.
     *
     * @param id     product id
     * @param amount amount
     * @return Boolean
     */
    Boolean addProduct(Integer id, Integer amount);

    /**
     * Remove product from basket.
     *
     * @param id product id
     * @return Boolean
     */
    Boolean removeProduct(Integer id);

    /**
     * Update product by id.
     *
     * @param id     product id
     * @param amount amount
     * @return Boolean
     */
    Boolean updateProduct(Integer id, Integer amount);

    /**
     * Get all products from basket.
     *
     * @return HashMap<Integer, Integer>
     */
    HashMap<Integer, Integer> findAll();

    /**
     * Get top products.
     *
     * @return LinkedHashMap<Long, Integer>
     */
    LinkedHashMap<Long, Integer> findTopProducts();

    /**
     * Clear basket.
     *
     * @return Boolean
     */
    Boolean removeAll();
}
