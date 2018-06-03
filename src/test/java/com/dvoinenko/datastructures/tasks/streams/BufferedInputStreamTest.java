package com.dvoinenko.datastructures.tasks.streams;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class BufferedInputStreamTest {
    @Test
    public void readArrayTest() throws FileNotFoundException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("log.txt"));

    }
}