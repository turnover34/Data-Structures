package com.dvoinenko.draft.network.socket.webserver;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestParser {

    static Request parseRequest(BufferedReader reader) throws NullPointerException, IOException {
        Request request = new Request();
        try {
            String line = reader.readLine();
        } catch (NullPointerException ex) {

        }



    }

    private Request injectUrlAndMethod(String requestLine) {

    }


}
