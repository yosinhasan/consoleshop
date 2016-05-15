package com.epam.pp.hasan.network.parser.impl;

import com.epam.pp.hasan.network.parser.RequestParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class TCPRequestParser implements RequestParser {
    private String action;
    private Map<String, String> query;
    public TCPRequestParser() {
        query = new HashMap<>();
    }

    @Override
    public void parse(String request) {
        if (request == null || request.isEmpty()) {
            action = null;
            query.clear();
            return;
        }
        String[] values = request.split("\\s");
        if (values.length != 2) {
            action = null;
            query.clear();
            return;
        }
        if (!values[0].equals("get")) {
            action = null;
            query.clear();
            return;
        }
        int index = values[1].lastIndexOf('=');
        if (index != -1) {
            action = values[1].substring(0, index);
            String id = values[1].substring(index + 1);
            if (id != null && !id.isEmpty()) {
                query.put("id", id);
            }
        } else {
            action = values[1];
            query.clear();
        }
    }

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public Map<String, String> getQuery() {
        return query;
    }
}
