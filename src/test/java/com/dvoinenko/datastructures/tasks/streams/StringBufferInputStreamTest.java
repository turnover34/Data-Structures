package com.dvoinenko.datastructures.tasks.streams;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class StringBufferInputStreamTest {

    @Test
    public void test() throws IOException {
        StringBufferInputStream stringBufferInputStream = null;
        StringBufferInputStream stringBufferInputStreamSecond = null;
        try {
            String text = "Java is fun ..";
            String nextText = "Java is great";
            stringBufferInputStream = new StringBufferInputStream(text);
            stringBufferInputStreamSecond = new StringBufferInputStream(nextText);
            while (stringBufferInputStream.available() > 0) {
                System.out.print((char) stringBufferInputStream.read());
            }
            System.out.println();
            byte[] array = new byte[7];
            stringBufferInputStreamSecond.read(array, 2, 4);
            while (stringBufferInputStreamSecond.available() > 0) {
                System.out.print((char) stringBufferInputStreamSecond.read());
            }
        }
        finally {
            stringBufferInputStream.close();
            stringBufferInputStreamSecond.close();
        }

    }


}