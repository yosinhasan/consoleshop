package com.epam.pp.hasan.controller;

import com.epam.pp.hasan.action.Action;
import com.epam.pp.hasan.action.ActionHolder;
import com.epam.pp.hasan.strategy.AddProduct;
import com.epam.pp.hasan.util.ProductHelper;
import com.epam.pp.hasan.util.Request;
import com.epam.pp.hasan.view.ViewResolver;

public class FrontController {
    private Request request;
    private ViewResolver view;
    private ActionHolder actionHolder;
    private AddProduct addProduct;

    /**
     *
     *
     */
    public FrontController() {
        this.request = new Request();
    }

    /**
     * Set action holder.
     *
     * @param holder action holder
     */
    public void setActionHolder(ActionHolder holder) {
        this.actionHolder = holder;
    }

    /**
     * Set view resolver.
     *
     * @param viewResolver view resolver
     */
    public void setViewResolver(ViewResolver viewResolver) {
        this.view = viewResolver;
    }

    /**
     * Set add product method.
     *
     * @param addProduct add product
     */
    public void setAddProductMethod(AddProduct addProduct) {
        this.addProduct = addProduct;
        request.set("helper", addProduct);
    }

    /**
     * Product helper.
     *
     * @param helper product helper
     */
    public void setProductHelper(ProductHelper helper) {
        request.set("productHelper", helper);
    }

    /**
     * Starting action.
     */
    public final void start(Integer actionNum) {
        Action action = actionHolder.get(actionNum);
        String viewName = action.execute(request);
        view.resolve(viewName, request);
    }

}
