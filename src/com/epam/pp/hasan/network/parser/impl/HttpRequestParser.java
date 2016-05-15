package com.epam.pp.hasan.network.parser.impl;

import com.epam.pp.hasan.network.parser.RequestParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class HttpRequestParser implements RequestParser {
    private String action;
    private Map<String, String> query;

    public HttpRequestParser() {
        query = new HashMap<>();
    }

    @Override
    public void parse(String request) {
        if (request == null || request.isEmpty()) {
            action = null;
            query.clear();
            return;
        }
        String[] values = request.split("/");
        if (values.length != 3) {
            action = null;
            query.clear();
            return;
        }
        if (!values[1].equals("shop")) {
            action = null;
            query.clear();
            return;
        }
        int index = values[2].lastIndexOf('?');
        if (index != -1) {
            action = values[2].substring(0, index);
            String queryString = values[2].substring(index + 1);
            parseQuery(query, queryString);
        } else {
            action = values[2];
            query.clear();
        }
    }

    private void parseQuery(Map<String, String> query, String queryString) {
        if (queryString == null || query == null || queryString.isEmpty()) {
            return;
        }
        if (queryString.indexOf("&") != -1) {
            String[] queries = queryString.split("&");
            String[] values = null;
            for (int i = 0; i < queries.length; i++) {
                values = queries[i].split("=");
                if (values.length == 2) {
                    query.put(values[0], values[1]);
                }
            }
        } else {
            String[] values = queryString.split("=");
            if (values.length == 2) {
                query.put(values[0], values[1]);
            }
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
