package com.epam.pp.hasan.facade.service.impl;

import com.epam.pp.hasan.entities.Product;
import com.epam.pp.hasan.facade.repository.product.ProductRepository;
import com.epam.pp.hasan.facade.service.ProductService;

import java.util.HashMap;

/**
 * Created by Yosin_Hasan on 5/12/2016.
 */
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRep;

    /**
     *
     * @param productRep product repository
     */
    public ProductServiceImpl(ProductRepository productRep) {
        this.productRep = productRep;
    }

    @Override
    public Product findProduct(Integer id) {
        return productRep.findProduct(id);
    }

    @Override
    public Product findProduct(String field, Object value) {
        return productRep.findProduct(field, value);
    }

    @Override
    public Boolean addProduct(Product product) {
        return productRep.addProduct(product);
    }

    @Override
    public Boolean removeProduct(Integer id) {
        return productRep.removeProduct(id);
    }

    @Override
    public Boolean removeProduct(String field, Object value) {
        return productRep.removeProduct(field, value);
    }

    @Override
    public Boolean updateProduct(Product product) {
        return productRep.updateProduct(product);
    }

    @Override
    public HashMap<Integer, Product> findAll() {
        return productRep.findAll();
    }
}
