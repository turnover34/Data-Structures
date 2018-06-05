package com.dvoinenko.datastructures.tasks.streams;

import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStream extends InputStream {

    private byte[] buffer;
    private int index;
    private int count;

    public ByteArrayInputStream(byte[] buffer) {
        this(buffer, 0, buffer.length);
    }

    public ByteArrayInputStream(byte[] buffer, int offset, int length) {
        if ( offset < 0 || length < 0 || offset > buffer.length) {
            throw new IllegalArgumentException();
        }
        this.buffer = buffer;
        count = offset + length;
        if (count > buffer.length) {
            count = buffer.length;
        }

        index = offset;
    }

    @Override
    public int read() throws IOException {
        if (index == count) {
            return -1;
        }
        return buffer[index++];
    }

    @Override
    public int read(byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    @Override
    public int read(byte[] array, int off, int len) throws IOException {
        if (index >= count) {
            return -1;
        } /*else if (len >= unreadedCount) {
            System.arraycopy(array, index, array, off, unreadedCount);
            index += unreadedCount;
            return unreadedCount;
        } else {
            System.arraycopy(array, index, array, off, len);
            index += len;
            return len;
        }*/
        int bytesCount = Math.min(count - index, len);
        System.arraycopy(buffer, index, array, off, bytesCount);
        index += bytesCount;
        return bytesCount;
    }
}
