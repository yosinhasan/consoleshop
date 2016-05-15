package com.epam.pp.hasan.actions;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.facade.service.ProductService;
import com.epam.pp.hasan.utils.Request;

public class Action404 extends Action {
    public Action404(ConsoleProductFacade productFacade) {
        super(productFacade);
    }

    @Override
    public String execute(Request request) {
        return Fields.ACTION_NOTFOUND;
    }

}
