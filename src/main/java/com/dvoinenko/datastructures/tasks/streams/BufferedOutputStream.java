package com.dvoinenko.datastructures.tasks.streams;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream extends OutputStream {

    private final static int DEFAULT_CAPACITY = 5;
    private OutputStream outputStream;
    private byte[] buffer;
    private int index;

    public BufferedOutputStream(OutputStream outputStream) {
        this(outputStream, DEFAULT_CAPACITY);
    }

    public BufferedOutputStream(OutputStream outputStream, int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("bufferSize should be over 0 but is: " + bufferSize);
        }
        this.outputStream = outputStream;
        this.buffer = new byte[bufferSize];
    }

    @Override
    public void write(int value) throws IOException {
        buffer[index++] = (byte)value;
        if (index == buffer.length) {
            flush();
        }
    }

    @Override
    public void write(byte[] array) throws IOException {
        write(array, 0, array.length);
    }

    @Override
    public void write(byte[] array, int off, int len) throws IOException {
        int emptySpace = array.length - index;
        if (emptySpace <= len) {
            flush();
            outputStream.write(array, off, len );
        } else {
            System.arraycopy(array, off, buffer, index, len);
            index += len;
        }
    }

    @Override
    public void flush() throws IOException {
        outputStream.write(buffer, 0, index);
        index = 0;
    }

    @Override
    public void close() throws IOException {
        flush();
        outputStream.close();
    }
}
