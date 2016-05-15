package com.epam.pp.hasan.network.server.handlers;

import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.facade.service.ProductService;

import java.net.Socket;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class ServerHandler extends Thread {
    protected Socket client;
    protected NetController controller;
    public ServerHandler(Socket client, NetController controller) {
        this.client = client;
        this.controller = controller;
    }

}
