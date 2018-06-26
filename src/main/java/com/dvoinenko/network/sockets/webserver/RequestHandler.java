package com.dvoinenko.network.sockets.webserver;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class RequestHandler {
    private BufferedReader bufferedReader;
    private BufferedOutputStream bufferedOutputStream;
    private ResourceReader resourceReader;

    public RequestHandler(BufferedReader bufferedReader, BufferedOutputStream bufferedOutputStream, ResourceReader resourceReader) {
        this.bufferedReader = bufferedReader;
        this.bufferedOutputStream = bufferedOutputStream;
        this.resourceReader = resourceReader;
    }

    public void handle() throws IOException {
        RequestParser requestParser = new RequestParser();
        ResponceWriter responceWriter = new ResponceWriter(bufferedOutputStream);
        try {
            Request request = requestParser.parseRequest(bufferedReader);
            try (InputStream inputStream = resourceReader.readContent(request.getUrl())) {
                responceWriter.writeSuccessResponse();
                responceWriter.writeContent(inputStream);
            } catch (IOException e) {
                responceWriter.writeNotFoundResponse();
            }
        } catch (Exception e) {
            responceWriter.writeBadRequestResponse();
        }
    }
}
