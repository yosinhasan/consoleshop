package com.epam.pp.hasan.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

public class Action404 extends Action {
    public Action404(ConsoleProductFacade productFacade) {
        super(productFacade);
    }

    @Override
    public String execute(Request request) {
        return Fields.ACTION_NOTFOUND;
    }

}
