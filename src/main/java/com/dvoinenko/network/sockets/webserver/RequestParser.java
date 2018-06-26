package com.dvoinenko.network.sockets.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {
    public Request parseRequest (BufferedReader reader) throws IOException {
        Request request = new Request();
        String requestLine = reader.readLine();
        injectUrlAndMethod(request, requestLine);
        injectHeaders(request, reader);
        return request;
    }

    private void injectUrlAndMethod(Request request, String requestLine) {
        try {
            String[] requestLineArry = requestLine.split(" ");
            String method = requestLineArry[0];
            String url = requestLineArry[1];
            HttpMethod httpMethod = HttpMethod.getHttpMethod(method);
            request.setMethod(httpMethod);
            request.setUrl(url);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    private void injectHeaders(Request request, BufferedReader requestReader) throws IOException {
        Map<String, String> headers = new HashMap<>();
        String line;
        try {
            while (!(line = requestReader.readLine()).isEmpty()) {
                String[] lineArray = line.split(": ");
                String atribute = lineArray[0];
                String value = lineArray[1];
                headers.put(atribute, value);
                request.setHeaders(headers);
            }
        } catch (IOException e) {
            throw new IOException();
        } catch (NullPointerException n) {
            throw new NullPointerException();
        }
    }
}
