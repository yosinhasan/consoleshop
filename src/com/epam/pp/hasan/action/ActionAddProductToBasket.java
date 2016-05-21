package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.ConsoleHelper;
import com.epam.pp.hasan.util.Request;

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
