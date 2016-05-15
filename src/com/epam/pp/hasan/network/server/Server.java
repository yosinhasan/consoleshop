package com.epam.pp.hasan.network.server;

import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.network.server.factory.ServerFactory;
import com.epam.pp.hasan.facade.service.ProductService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class Server extends Thread {
    private Integer port;
    private ServerFactory factory;
    private NetController controller;

    public Server(Integer port, ServerFactory factory, NetController controller) {
        this.port = port;
        this.factory = factory;
        this.controller = controller;
        setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println("SERVER STARTED...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket client = serverSocket.accept();
                factory.getHandler(client, controller).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}