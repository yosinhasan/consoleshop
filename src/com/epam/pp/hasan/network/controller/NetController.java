package com.epam.pp.hasan.network.controller;

import com.epam.pp.hasan.network.action.Action;
import com.epam.pp.hasan.network.action.ActionHolder;
import com.epam.pp.hasan.network.type.Type;
import com.epam.pp.hasan.util.Request;
import com.epam.pp.hasan.network.view.ViewResolver;

import java.util.Map;

public class NetController {
    private Request request;
    private ViewResolver view;
    private ActionHolder actionHolder;

    /**
     *
     */
    public NetController(Type type) {
        this.request = new Request();
        request.set("type", type);
    }

    /**
     * Set action holder.
     *
     * @param holder action holder
     */
    public void setActionHolder(ActionHolder holder) {
        this.actionHolder = holder;
    }

    /**
     * Set view resolver.
     *
     * @param viewResolver view resolver
     */
    public void setViewResolver(ViewResolver viewResolver) {
        this.view = viewResolver;
    }

    /**
     * Starting action.
     */
    public final String start(String actionName, Map<String, String> query) {
        if (query != null) {
            request.set("query", query);
        }
        Action action = actionHolder.get(actionName);
        String viewName = action.execute(request);
        String result = view.resolve(viewName, request);
        return result;
    }

}
