package com.dvoinenko.datastructures.tasks.reader;


import java.io.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromIn extends Thread implements Runnable {

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
