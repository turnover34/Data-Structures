package com.dvoinenko.datastructures.tasks.reader;

public class Server {
    public static void main(String[] args) throws InterruptedException {
        ReaderFromIn reader = new ReaderFromIn();
        FileWriterFromStack writer = new FileWriterFromStack();
        while (true) {
            reader.start();
            writer.start();
        }
    }
}
