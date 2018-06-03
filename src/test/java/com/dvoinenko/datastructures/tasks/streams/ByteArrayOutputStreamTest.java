package com.dvoinenko.datastructures.tasks.streams;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

    public class ByteArrayOutputStreamTest {
        @Test
        public void writeArrayTest() throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String text = "Hello world!";
            byte[] byteArray = text.getBytes();
            byteArrayOutputStream.write(byteArray);
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            byteArrayOutputStream.writeTo(fileOutputStream);
            byteArrayOutputStream.close();
            fileOutputStream.close();
/*            ByteArrayOutputStream byteArrayOutputStreamSecond = new ByteArrayOutputStream();
            String oneMoreString = "Java is painful but joyful";
            byte[] bytes = oneMoreString.getBytes();
            byteArrayOutputStreamSecond.write(bytes, 20, 6);
            FileOutputStream fileOutputStreamSecond = new FileOutputStream("test.txt");
            byteArrayOutputStreamSecond.writeTo(fileOutputStreamSecond);
            byteArrayOutputStreamSecond.close();
            fileOutputStreamSecond.close();*/
        }
    }

