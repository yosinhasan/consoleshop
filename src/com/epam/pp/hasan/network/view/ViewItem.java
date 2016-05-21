package com.epam.pp.hasan.network.view;

import com.epam.pp.hasan.entity.Product;
import com.epam.pp.hasan.network.type.Type;
import com.epam.pp.hasan.util.Request;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class ViewItem implements View {
    @Override
    public String view(Request request) {
        Product item = (Product) request.get("item");
        request.remove("item");
        Type type = (Type) request.get("type");
        String response = null;
        if (type == Type.HTTP) {
            if (item != null) {
                response = "{name: " + item.getName() + ", price:" + item.getPrice() + "}";
            } else {
                String error = (String) request.get("errorMessage");
                if (error != null && !error.isEmpty()) {
                    request.remove("errorMessage");
                    response = "{error: ILLEGAL ARGUMENT " + error.toUpperCase() + "}";
                } else {
                    response = "{error: PRODUCT NOT FOUND}";
                }
            }
        } else {
            if (item != null) {
                response = "PRODUCT NAME: " + item.getName() + " | PRODUCT PRICE: " + item.getPrice();
            } else {
                String error = (String) request.get("errorMessage");
                if (error != null && !error.isEmpty()) {
                    request.remove("errorMessage");
                    response = "ILLEGAL ARGUMENT " + error.toUpperCase();
                } else {
                    response = "PRODUCT NOT FOUND";
                }
            }
        }
        return response;
    }
}
