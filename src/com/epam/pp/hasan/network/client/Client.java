package com.epam.pp.hasan.network.client;

import com.epam.pp.hasan.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Yosin_Hasan on 5/10/2016.
 */
public class Client {
    private Integer port;
    private String host;

    public Client(Integer port, String host) {
        this.port = port;
        this.host = host;
    }

    public void start() {
        try (Socket socket = new Socket(host, port)) {
            try (BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()))) {
                    try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                        System.out.printf("I am a client: %s (type 'stop' to exit)%n", socket.getLocalPort());
                        String mes = null;
                        while (!"stop".equals(mes)) {
                            mes = stdin.readLine();
                            out.println(mes);
                            System.out.println("Response: " + in.readLine());
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client(Constants.PORT, Constants.HOST);
        client.start();
    }
}
