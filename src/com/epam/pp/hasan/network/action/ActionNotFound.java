package com.epam.pp.hasan.network.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class ActionNotFound extends Action {
    public ActionNotFound(ConsoleProductFacade facade) {
        super(facade);
    }

    @Override
    public String execute(Request request) {
        return Fields.ACTION_NOTFOUND;
    }
}
