package com.epam.pp.hasan.network.server.factory.impl;

import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.network.server.factory.ServerFactory;
import com.epam.pp.hasan.network.server.handlers.ServerHandler;
import com.epam.pp.hasan.network.server.handlers.impl.HttpServerHandler;
import com.epam.pp.hasan.facade.service.ProductService;

import java.net.Socket;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class HttpServerFactory implements ServerFactory {
    @Override
    public ServerHandler getHandler(Socket client, NetController controller) {
        return new HttpServerHandler(client, controller);
    }
}
