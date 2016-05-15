package com.epam.pp.hasan.network.parser.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by elpai on 10.05.16.
 */
public class TCPRequestParserTest {
    private TCPRequestParser parser;

    @Before
    public void init() {
        parser = new TCPRequestParser();
    }

    @Test
    public void testGetAction() throws Exception {
        String query = "get count";
        parser.parse(query);
        String expected = "count";
        String actual = parser.getAction();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuery() throws Exception {
        String query = "get item=20";
        parser.parse(query);
        String expected = "20";
        String actual = parser.getQuery().get("id");
        assertEquals(expected, actual);
    }
}