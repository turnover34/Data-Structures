package com.dvoinenko.datastructures.tasks.streams;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ByteArrayInputStreamTest {

    @Test
    public void readTest() throws Exception {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byte[] buffer = {1, 2, 3, 5, 8, 9, 21, 23};
            byteArrayInputStream = new ByteArrayInputStream(buffer);
            byteArrayInputStream.read();
            byteArrayInputStream.read();
            byteArrayInputStream.read();
            assertEquals(5, byteArrayInputStream.read());
            assertEquals(8, byteArrayInputStream.read());
        }
        finally {
            byteArrayInputStream.close();
        }

    }

    @Test
    public void readArrayTest() throws Exception {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(new byte[] {3, 6, 9, 12, 15});
            byte[] buffer = new byte[4];
            int count = byteArrayInputStream.read(buffer);
            assertEquals(4, count);
            assertEquals(6, buffer[1]);
            assertEquals(12, buffer[3]);

            count = byteArrayInputStream.read(buffer);
            assertEquals(1, count);
            assertEquals(15, buffer[0]);

            count = byteArrayInputStream.read(buffer);
            assertEquals(-1, count);
        }
        finally {
            byteArrayInputStream.close();
        }

    }

}

