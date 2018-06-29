package com.dvoinenko.datastructures.tasks.reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWriterFromStack extends Thread implements Runnable {
    File file;
    List<String> list = new ArrayList<>();

    String path = "C:\\Users\\Ivan\\IdeaProjects\\datastructures\\src\\main\\resources\\file.txt";


    public File checkForFile(String path) throws IOException {
        if (file.exists()) {
            return file;
        } else {
            file.createNewFile();
        }
        return file;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            List<String> list = getList();
            for (String line : list) {
                Thread.sleep(15000);
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
