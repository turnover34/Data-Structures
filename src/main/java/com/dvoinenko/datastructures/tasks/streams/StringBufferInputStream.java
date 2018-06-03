package com.dvoinenko.datastructures.tasks.streams;

import java.io.IOException;
import java.io.InputStream;

public class StringBufferInputStream extends InputStream {
    protected String buffer;
    protected int index;
    protected int count;

    public StringBufferInputStream(String buffer) {
        this.buffer = buffer;
        count = buffer.length();
    }

    @Override
    public int read() throws IOException {
        if (index == count) {
            return -1;
        }
        return (int) (buffer.charAt(index++));
    }

    public int read (byte[] array, int off, int len) {
        if (off < 0 || len < 0 || (off + len > array.length)) {
            throw new ArrayIndexOutOfBoundsException("You entered improper parameters");
        } else if (index == count) {
            return -1;
        }
        int toReadCount = Math.min(len, count - index);
        if (toReadCount < 0) {
            return 0;
        }

        System.arraycopy(buffer.getBytes(), index, array, off, toReadCount);
        index += toReadCount;
        return toReadCount;
    }
}
