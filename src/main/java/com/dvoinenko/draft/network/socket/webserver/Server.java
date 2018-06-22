package com.dvoinenko.draft.network.socket.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private String resoursePath;




    private void setPort(int port) {
        this.port = port;
    }
    private void setResoursePath(String resoursePath) {
        this.resoursePath = resoursePath;
    }
    private void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            RequestHandler requestHandler = new RequestHandler(reader, writer);
            requestHandler.handle();

        }
    }
}
