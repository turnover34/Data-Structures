package com.dvoinenko.datastructures.tasks.streams;

import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStream extends InputStream {

    private InputStream inputStream;
    private int index;
    private int count;
    private byte[] buffer;

    public ByteArrayInputStream(byte[] buffer) {
        this.buffer = buffer;
        this.index = 0;
        this.count = buffer.length;
    }

    @Override
    public int read() throws IOException {
        if (index < count) {
            return buffer[index++];
        }
        else {
            return -1;
        }
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }

}
