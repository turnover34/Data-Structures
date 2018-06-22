package com.dvoinenko.draft.network.socket.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {


    public Request parseRequest(BufferedReader reader) throws IOException {
        Request request = new Request();
        String requestLineline;
        if ((requestLineline = reader.readLine()) != null) {
            injectUrlAndMethod(request, requestLineline);
            injectHeaders(request, reader);
        }
        return request;
    }

    private void injectUrlAndMethod(Request request, String requestLine) {
        String[] requestLineArguments = requestLine.split(" ");
        if (requestLineArguments[0].equals("GET")) {
            request.setMethod(HttpMethod.GET);
            request.setUrl(requestLineArguments[1]);
        }
    }

    private void injectHeaders(Request request, BufferedReader reader) throws IOException {
        Map<String, String> headers = new HashMap<>();
        String headersLine;
        while ((headersLine = reader.readLine()) != null) {
            String[] headersLineParams = headersLine.split(" ");
            String header = headersLineParams[0];
            String headerValue = headersLineParams[1];
            headers.put(header, headerValue);
        }
        request.setHeaders(headers);
    }
}
