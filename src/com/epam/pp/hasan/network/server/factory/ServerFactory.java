package com.epam.pp.hasan.network.server.factory;

import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.network.server.handlers.ServerHandler;
import com.epam.pp.hasan.facade.service.ProductService;

import java.net.Socket;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public interface ServerFactory {
    ServerHandler getHandler(Socket client, NetController controller);
}
