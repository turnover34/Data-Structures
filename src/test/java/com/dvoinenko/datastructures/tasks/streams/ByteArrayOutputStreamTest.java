package com.dvoinenko.datastructures.tasks.streams;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

    public class ByteArrayOutputStreamTest {
        @Test
        public void writeArrayTest() throws IOException {
            /*FileOutputStream fileOutputStream = null;
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                fileOutputStream = new FileOutputStream("test.txt");
                String text = "Hello world!";
                byte[] byteArray = text.getBytes();
                byteArrayOutputStream.write(byteArray);
                byteArrayOutputStream.writeTo(fileOutputStream);
            }
            finally {
                byteArrayOutputStream.close();
                fileOutputStream.close();
            }*/


            FileOutputStream fileOutputStreamSecond = null;
            ByteArrayOutputStream byteArrayOutputStreamSecond = null;
            try {
                byteArrayOutputStreamSecond = new ByteArrayOutputStream();
                fileOutputStreamSecond = new FileOutputStream("test.txt");
                String oneMoreString = "Java is painful but joyful";
                byte[] bytes = oneMoreString.getBytes();
                byteArrayOutputStreamSecond.write(bytes, 20, 6);
                byteArrayOutputStreamSecond.writeTo(fileOutputStreamSecond);
            }
            finally {
                byteArrayOutputStreamSecond.close();
                fileOutputStreamSecond.close();
            }

        }
    }

