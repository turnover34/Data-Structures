package com.dvoinenko.datastructures.tasks.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    private int index;
    private int count;
    private byte[] buffer;

    public ByteArrayOutputStream(byte[] buffer) {
        this.buffer = buffer;
        this.index = 0;
        this.count = buffer.length;
    }

    @Override
    public void write(int b) throws IOException {

    }
}
