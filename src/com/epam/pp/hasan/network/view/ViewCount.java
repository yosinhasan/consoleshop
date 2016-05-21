package com.epam.pp.hasan.network.view;

import com.epam.pp.hasan.network.type.Type;
import com.epam.pp.hasan.util.Request;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class ViewCount implements View {
    @Override
    public String view(Request request) {
        Type type = (Type) request.get("type");
        String response = null;
        Integer count = (Integer) request.get("count");
        request.remove("count");
        response = "THERE ARE " + count + " PRODUCTS";
        if (type == Type.HTTP) {
            response = "{count:" + count + "}";
        }
        return response;
    }
}
