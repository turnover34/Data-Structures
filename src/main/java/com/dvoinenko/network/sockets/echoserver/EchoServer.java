package com.dvoinenko.network.sockets.echoserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3000);
             Socket socket = serverSocket.accept();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {
             while (true) {
                 String input = bufferedReader.readLine();
                 printWriter.write("echo: " + input + "\n");
                 printWriter.flush();
             }
        }
    }
}
