package com.epam.pp.hasan.network.server.handlers.impl;

import com.epam.pp.hasan.network.controller.NetController;
import com.epam.pp.hasan.network.parser.impl.HttpRequestParser;
import com.epam.pp.hasan.network.server.handlers.ServerHandler;
import com.epam.pp.hasan.facade.service.ProductService;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class HttpServerHandler extends ServerHandler {
    private HttpRequestParser parser;

    public HttpServerHandler(Socket client, NetController controller) {
        super(client, controller);
        parser = new HttpRequestParser();
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())); OutputStream out = client.getOutputStream()) {
            String mes = null;
            String result = null;
            try {
                String request = readInputHeaders(in);
                parser.parse(getURIFromHeader(request));
                result = controller.start(parser.getAction(), parser.getQuery());
                writeResponse(out, result);
            } catch (Throwable e) {
                e.printStackTrace();
                client.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getURIFromHeader(String header) {
        int from = header.indexOf(" ") + 1;
        int to = header.indexOf(" ", from);
        String uri = null;
        if (to > from) {
            uri = header.substring(from, to);
        }
        return uri;
    }

    private void writeResponse(OutputStream out, String text) throws Throwable {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Date: " + new Date() + "\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + text.length() + "\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + text;
        out.write(result.getBytes());
        out.flush();
    }

    private String readInputHeaders(BufferedReader in) throws Throwable {
        String header = null;
        StringBuilder builder = new StringBuilder();
        String ln = null;
        while (true) {
            ln = in.readLine();
            if (ln == null || ln.isEmpty()) {
                break;
            }
            builder.append(ln + System.getProperty("line.separator"));
        }
        return builder.toString();
    }

}
