package com.epam.pp.hasan.network.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class ActionCount extends Action {
    public ActionCount(ConsoleProductFacade facade) {
        super(facade);
    }

    @Override
    public String execute(Request request) {
        Integer count = facade.findAll().size();
        request.set("count", count);
        return Fields.NETWORK_ACTION_COUNT;
    }
}
