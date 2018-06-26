package com.dvoinenko.draft.network.socket.webserver;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private String path;
    private ResourceReader resourceReader;


    public void setPort(int port) {
        this.port = port;
    }

    public void setResourcePath(String path) {
        this.path = path;
    }

    public void start() throws IOException {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = server.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream())) {
                        RequestHandler handler = new RequestHandler();
                        handler.handle();
                }
            }
        }
    }
}
