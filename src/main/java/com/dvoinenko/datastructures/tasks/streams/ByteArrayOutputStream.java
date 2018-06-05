package com.dvoinenko.datastructures.tasks.streams;

import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    private final static int DEFAULT_SIZE = 5;
    private byte[] buffer;
    private int count; // number of bytes written to buffer

    public ByteArrayOutputStream() {
        this(DEFAULT_SIZE);
    }

    public ByteArrayOutputStream(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size should be over 0, but is: " + size);
        }
        buffer = new byte[size];
    }


    @Override
    public void write(int value) {
        resize(1);
        buffer[count++] = (byte) value;
    }

    @Override
    public void write(byte[] array) {
        write(array, 0, array.length);
    }

    @Override
    public void write(byte[] array, int off, int len) {
        if (len >= 0) {
            resize(len);
        }
        System.arraycopy(array, off, buffer, count, len);
        count += len;
    }

    private void resize(int add) {
        if (count + add > buffer.length) {
            int newLength = buffer.length * 2;
            if (count + add > newLength) {
                newLength = count + add;
            }
            byte[] newBuffer = new byte[newLength];
            System.arraycopy(buffer, 0, newBuffer, 0, count);
            buffer = newBuffer;
        }
    }


    public void writeTo(OutputStream out) throws IOException {
        out.write(buffer, 0, count);
    }
}
