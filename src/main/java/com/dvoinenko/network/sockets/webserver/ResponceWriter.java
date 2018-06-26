package com.dvoinenko.network.sockets.webserver;

import java.io.*;

public class ResponceWriter {
    private BufferedOutputStream bufferedOutputStream;

    private static final int DEFAULT_SIZE = 1024;
    private static final byte[] EMPTY_LINE = "\r\n".getBytes();
    private static final byte[] SUCCESS_RESPONSE = "HTTP/1.1 200 OK\n".getBytes();
    private static final byte[] NOT_FOUND_RESPONSE = "HTTP/1.1 404 NotFound\n".getBytes();
    private static final byte[] BAD_REQUEST_RESPONSE = "HTTP/1.1 400 BadRequest\n".getBytes();

    public ResponceWriter(BufferedOutputStream bufferedOutputStream) {
        this.bufferedOutputStream = bufferedOutputStream;
    }

    public void writeContent(InputStream inputStream) throws IOException {
        int countBytes;
        byte[] buffer = new byte[DEFAULT_SIZE];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while ((countBytes = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, countBytes);
        }
        bufferedOutputStream.write(EMPTY_LINE);
    }


    public void writeSuccessResponse() throws IOException {
        bufferedOutputStream.write(SUCCESS_RESPONSE);
        bufferedOutputStream.write(EMPTY_LINE);
    }

    public void writeNotFoundResponse() throws IOException {
        bufferedOutputStream.write(NOT_FOUND_RESPONSE);
        bufferedOutputStream.write(EMPTY_LINE);
    }

    public void writeBadRequestResponse() throws IOException {
        bufferedOutputStream.write(BAD_REQUEST_RESPONSE);
        bufferedOutputStream.write(EMPTY_LINE);
    }
}
