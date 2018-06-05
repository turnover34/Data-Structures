package com.dvoinenko.datastructures.tasks.streams;

import org.junit.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class BufferedInputStreamTest {

    public BufferedInputStreamTest() throws FileNotFoundException {
    }

    @Test
    public void readTest() throws Exception {
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("log.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            int value;
            while ((value = bufferedInputStream.read()) != -1) {
                stringBuilder.append((char) value);
            }
            System.out.println(stringBuilder.toString());
        }
        finally {
            bufferedInputStream.close();
        }

    }

    @Test
    public void readArrayTest() throws Exception {
        BufferedInputStream bufferedInputStream = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("bist.txt");
            bufferedInputStream = new BufferedInputStream(inputStream, 6);
            int totalByteCount = bufferedInputStream.available();
            byte[] array = new byte[totalByteCount];
            bufferedInputStream.read(array, 2, 3);
            for (byte simpleByte : array) {
                System.out.println("simple byte "+ (char) simpleByte);
            }
        }
        finally {
            inputStream.close();
            bufferedInputStream.close();
        }
    }
}