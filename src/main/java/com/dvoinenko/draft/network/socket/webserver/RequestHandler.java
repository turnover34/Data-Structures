package com.dvoinenko.draft.network.socket.webserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RequestHandler {
    private BufferedReader reader;
    private BufferedWriter writer;

    public ResourceReader getResourceReader() {
        return resourceReader;
    }

    public void setResourceReader(ResourceReader resourceReader) {
        this.resourceReader = resourceReader;
    }

    private ResourceReader resourceReader;

    public RequestHandler(BufferedReader reader, BufferedWriter writer, ResourceReader resourceReader) {
        this.reader = reader;
        this.writer = writer;
        this.resourceReader = resourceReader;
    }


    public void handle() throws IOException {
        RequestParser parser = new RequestParser();
        Request request = parser.parseRequest(reader);

        ResponseWriter responseWriter = new ResponseWriter(writer);
        String content = resourceReader.readContent(request.getUrl());
        if (content != null) {
            responseWriter.writeSuccessResponse(content);
        } else {
            responseWriter.writeNotFoundResponse();
        }
    }
}
