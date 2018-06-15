package com.dvoinenko.network.sockets;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        try(Socket echoSocket = new Socket("localhost", 3000);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;
            while ((userInput = input.readLine()) != null) {
                out.write(userInput);
                System.out.print(input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
