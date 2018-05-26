package com.dvoinenko.datastructures.tasks.streams;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream extends OutputStream {

    private static final int INITIAL_CAPACITY = 10;
    private byte[] buffer = new byte[INITIAL_CAPACITY];
    private OutputStream outputStream;
    private int count;

    public BufferedOutputStream(OutputStream outputStream) {
        this(outputStream, INITIAL_CAPACITY);
    }

    public BufferedOutputStream(OutputStream out, int size) {
        this.outputStream = out;
        if (size <= 0) {
            throw new IllegalArgumentException("The size of buffer should be greater than 0, but is " + size);
        }
        buffer = new byte[size];
    }

    @Override
    public void write(int symbol) throws IOException {
        if(count >= buffer.length) {
            flush();
        }
        buffer[count++] = (byte)symbol;
    }

    public void flush() throws IOException {
        if (count > 0) {
            outputStream.write(buffer);
            count = 0;
        }
    }

    public void close() throws IOException {
        outputStream.close();
    }

}
