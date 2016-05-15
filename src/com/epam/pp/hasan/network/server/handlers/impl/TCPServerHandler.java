package com.epam.pp.hasan.network.server.handlers.impl;

import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.network.parser.impl.TCPRequestParser;
import com.epam.pp.hasan.network.server.handlers.ServerHandler;
import com.epam.pp.hasan.facade.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class TCPServerHandler extends ServerHandler {
    private TCPRequestParser parser;
    public TCPServerHandler(Socket client, NetController controller) {
        super(client, controller);
        parser = new TCPRequestParser();
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                client.getInputStream())); PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
            String mes = null;
            String result = null;
            while (!"stop".equals(mes)) {
                String request = in.readLine();
                parser.parse(request);
                result = controller.start(parser.getAction(), parser.getQuery());
                out.println(result);
            }
            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
