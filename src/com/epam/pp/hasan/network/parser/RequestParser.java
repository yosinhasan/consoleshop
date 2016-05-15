package com.epam.pp.hasan.network.parser;

import java.util.Map;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public interface RequestParser {
    void parse(String request);
    String getAction();
    Map<String, String> getQuery();
}
