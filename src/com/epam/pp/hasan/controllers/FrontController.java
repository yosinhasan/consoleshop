package com.epam.pp.hasan.controllers;

import com.epam.pp.hasan.actions.Action;
import com.epam.pp.hasan.actions.ActionHolder;
import com.epam.pp.hasan.strategy.AddProduct;
import com.epam.pp.hasan.utils.Request;
import com.epam.pp.hasan.views.ViewResolver;

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
     * Starting actions.
     */
    public final void start(Integer actionNum) {
        Action action = actionHolder.get(actionNum);
        String viewName = action.execute(request);
        view.resolve(viewName, request);
    }

}
