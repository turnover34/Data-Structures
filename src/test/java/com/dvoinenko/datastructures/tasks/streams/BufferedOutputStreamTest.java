package com.dvoinenko.datastructures.tasks.streams;

import org.junit.Test;


import java.io.FileOutputStream;

import static org.junit.Assert.*;

public class BufferedOutputStreamTest {

    @Test
    public void test() throws Exception {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("log.txt"))) {
            String content = "Hello !!";
            byte[] contentArray = content.getBytes();

            bufferedOutputStream.write(contentArray[0]);
            bufferedOutputStream.write(contentArray, 1, contentArray.length -1);
        }
    }
}