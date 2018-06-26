package com.dvoinenko.network.sockets.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private String path;

    public void setPort(int port) {
        this.port = port;
    }

    public void setWebappPath(String path) {
        this.path = path;
    }

    public void start() throws IOException {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = server.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream())) {
                    ResourceReader resourceReader = new ResourceReader(path);
                    RequestHandler requestHandler = new RequestHandler(bufferedReader, bufferedOutputStream, resourceReader);
                    requestHandler.handle();
                }
            }
        }
    }
}
