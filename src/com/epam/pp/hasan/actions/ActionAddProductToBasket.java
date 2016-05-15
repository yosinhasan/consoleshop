package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.ConsoleHelper;
import com.epam.pp.hasan.utils.Request;

public class ActionAddProductToBasket extends Action {
    public ActionAddProductToBasket(ConsoleProductFacade productFacade) {
        super(productFacade);
    }

    @Override
    public String execute(Request request) {
        Integer code = ConsoleHelper.getInt("Input product code:");
        Integer amount = ConsoleHelper.getInt("Input amount: ");
        request.set("isAdded", productFacade.addToBasket(code, amount));
        return Fields.ACTION_ADD_TO_BASKET;
    }
}
