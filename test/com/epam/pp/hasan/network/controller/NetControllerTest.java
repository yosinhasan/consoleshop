package com.epam.pp.hasan.network.controller;

import com.epam.pp.hasan.Fields;
import com.epam.pp.hasan.network.actions.Action;
import com.epam.pp.hasan.network.actions.ActionHolder;
import com.epam.pp.hasan.network.actions.ActionNotFound;

import java.util.Map;
import java.util.TreeMap;

import com.epam.pp.hasan.network.views.View;
import com.epam.pp.hasan.network.views.ViewNotFound;
import com.epam.pp.hasan.network.views.ViewResolver;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Created by elpai on 10.05.16.
 */
public class NetControllerTest {

    @Test
    public void testStart() throws Exception {
        NetController controller = spy(new NetController(null, null));
        init(controller);
        when(controller.start(Fields.ACTION_NOTFOUND, null)).thenReturn("good");
        assertEquals("good", controller.start(Fields.ACTION_NOTFOUND, null));
    }

    private void init(NetController controller) {
        Map<String, Action> actions = new TreeMap<String, Action>();
        Map<String, View> views = new TreeMap<String, View>();
        actions.put(Fields.ACTION_NOTFOUND, new ActionNotFound());
        views.put(Fields.ACTION_NOTFOUND, new ViewNotFound());
        controller.setActionHolder(new ActionHolder(actions));
        controller.setViewResolver(new ViewResolver(views));

    }
}