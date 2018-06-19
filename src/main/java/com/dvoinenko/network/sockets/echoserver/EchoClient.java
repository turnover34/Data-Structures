package com.dvoinenko.network.sockets.echoserver;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        try(Socket echoSocket = new Socket("localhost", 3000);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()))) {
            String userInput, serverInput;
            while ((userInput = input.readLine()) != null) {
                out.write(userInput + "\n");
                out.flush();
                serverInput = inputFromServer.readLine();
                System.out.println(serverInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
