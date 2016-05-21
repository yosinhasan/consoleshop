package com.epam.pp.hasan.network.action;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.facade.ConsoleProductFacade;
import com.epam.pp.hasan.util.Request;

import java.util.Map;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class ActionItem extends Action {
    public ActionItem(ConsoleProductFacade facade) {
        super(facade);
    }

    @Override
    public String execute(Request request) {
        Map<String, String> query = (Map<String, String>) request.get("query");
        if (query != null && query.get("id") != null) {
            try {
                Integer id = Integer.parseInt(query.get("id"));
                Product item = facade.findProduct(id);
                request.set("item", item);
            } catch (Throwable e) {
                request.set("errorMessage", e.getMessage());
            }
        }
        return Fields.NETWORK_ACTION_ITEM;
    }
}
