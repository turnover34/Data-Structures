package com.dvoinenko.network.sockets.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private static int port;
    private String path;

    private static final String OK = "HTTP/1.1 200 OK";
    private static final String BAD_REQUEST = "HTTP/1.1 400 Bad Request";
    private static final String NOT_FOUND = "HTTP/1.1 404 Not Found";

    public void setServer(int port) {
        this.port = port;
    }


    public void setWebAppPath(String path) {
        this.path = path;
    }

    public void start() throws IOException {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = server.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                        String requestLine = reader.readLine();
                        if (requestLine != null) {
                            String[] startingLineMessage = requestLine.split(" ");
                            if (startingLineMessage[0].equals("GET")) {
                                String resoursePath = path + startingLineMessage[1];
                                find(resoursePath, writer);
                            } else {
                            String answer = BAD_REQUEST;
                            sendAnswer(answer, writer);
                        }
                    }
                }
            }
        }
    }

    private void find(String resoursePath, BufferedWriter writer) throws IOException {
        File file = new File(resoursePath);
            if (!file.exists()) {
                String answer = NOT_FOUND;
                sendAnswer(answer, writer);
            } else  {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                String fileLine;
                while ((fileLine = reader.readLine()) != null) {
                    writer.write(fileLine);
                }
                writer.newLine();
            }
        }
    }

    public void sendAnswer(String responseLine, BufferedWriter writer) throws IOException {
        writer.write(responseLine);
        writer.newLine();
        writer.flush();
    }
}
