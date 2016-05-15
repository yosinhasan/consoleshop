package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.Request;

public abstract class Action {
    protected ConsoleProductFacade productFacade;

    public Action(ConsoleProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    /**
     * Executing action.
     */
    public abstract String execute(Request request);
}
