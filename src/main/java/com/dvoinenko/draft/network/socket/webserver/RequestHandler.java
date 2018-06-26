package com.dvoinenko.draft.network.socket.webserver;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;

public class RequestHandler {
    private BufferedReader reader;
    private BufferedOutputStream outputStream;
    private ResourceReader resourcePath;

    void handle() {

    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setOutputStream(BufferedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setResourcePath(ResourceReader resourcePath) {
        this.resourcePath = resourcePath;
    }
}
