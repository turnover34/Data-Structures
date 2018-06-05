package com.dvoinenko.datastructures.tasks.streams;

import org.junit.Test;


import java.io.FileOutputStream;


import static org.junit.Assert.*;

public class BufferedOutputStreamTest {

    @Test
    public void test() throws Exception {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("log.txt"));
            String content = "Hello !!";
            byte[] contentArray = content.getBytes();
            assertEquals('H', contentArray[0]);
            assertEquals('!', contentArray[7]);

            bufferedOutputStream.write(contentArray[0]);
            bufferedOutputStream.write(contentArray, 1, contentArray.length -1);
        }
        finally {
            bufferedOutputStream.close();
        }
    }
}