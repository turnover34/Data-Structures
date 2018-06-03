package com.dvoinenko.datastructures.tasks.streams;

import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStream extends InputStream {

    private byte[] array;
    private int index;

    public ByteArrayInputStream(byte[] buffer) {
        this.array = buffer;
    }

    @Override
    public int read() throws IOException {
        if (index == array.length) {
            return -1;
        }
        return array[index++];
    }

    @Override
    public int read(byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    @Override
    public int read(byte[] buffer, int off, int len) throws IOException {
        int unreadedCount = array.length - index;
        if (array.length == index) {
            return -1;
        } else if (len >= unreadedCount) {
            System.arraycopy(array, index, buffer, off, unreadedCount);
            index += unreadedCount;
            return unreadedCount;
        } else {
            System.arraycopy(array, index, buffer, off, len);
            index += len;
            return len;
        }
    }
}
