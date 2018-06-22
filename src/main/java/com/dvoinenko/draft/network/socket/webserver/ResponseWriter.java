package com.dvoinenko.draft.network.socket.webserver;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {
    private BufferedWriter writer;

    public ResponseWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    public void writeSuccessResponse(String content) throws IOException {
        writer.write("HTTP/1.1 200 OK\n");
        writer.newLine();
        writer.write(content);
        writer.newLine();

    }

    public void writeNotFoundResponse() throws IOException {
        writer.write("HTTP/1.1 404 Not Found\n");
    }

    public void writeBadRequestResponse() throws IOException {
        writer.write("HTTP/1.1 400 Bad Request\n");
    }
}
