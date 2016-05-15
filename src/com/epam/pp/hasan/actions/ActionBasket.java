package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.Request;

public class ActionBasket extends Action {

    public ActionBasket(ConsoleProductFacade productFacade) {
        super(productFacade);
    }

    @Override
    public String execute(Request request) {
        request.set("basket", productFacade.getBasketProducts());
        request.set("products", productFacade.findAll());
        return Fields.ACTION_BASKET;
    }

}
