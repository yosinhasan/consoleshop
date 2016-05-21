package com.epam.pp.hasan.network.view;

import com.epam.pp.hasan.util.Request;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class ViewNotFound implements View {
    @Override
    public String view(Request request) {
        return "ACTION NOT FOUND";
    }
}
