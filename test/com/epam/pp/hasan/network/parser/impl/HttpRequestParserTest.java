package com.epam.pp.hasan.network.parser.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by elpai on 10.05.16.
 */
public class HttpRequestParserTest {
    private HttpRequestParser parser;

    @Before
    public void init() {
        parser = new HttpRequestParser();
    }

    @Test
    public void testGetAction() throws Exception {
        String query = "/shop/count";
        parser.parse(query);
        String expected = "count";
        String actual = parser.getAction();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuery() throws Exception {
        String query = "/shop/item?id=20";
        parser.parse(query);
        String expected = "20";
        String actual = parser.getQuery().get("id");
        assertEquals(expected, actual);
    }
}