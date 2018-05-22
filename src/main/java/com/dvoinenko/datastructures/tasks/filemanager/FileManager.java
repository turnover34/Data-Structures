package com.dvoinenko.datastructures.tasks.filemanager;

/*1) Написать класс FileManager и тесты на него, со следующими методами:
        - public static int calculateFiles(String path) - принимает путь к папке,
        возвращает количество файлов в папке и всех подпапках по пути
        - public static int calculateDirs(String path) - принимает путь к папке,
        возвращает количество папок в папке и всех подпапках по пути
        - public static void copy(String from, String to) - метод по копированию папок и файлов.
        Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
        - public static void move(String from, String to) - метод по перемещению папок и файлов.
        Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться перемещение.*/

import java.io.*;

public class FileManager {
    public static long calculateFiles(String directoryPath) throws IOException {
        long filesCount = 0;
        File path = new File(directoryPath);
        if (!path.exists()) {
            throw new IOException("Such path doesn't exist " + path);
        }
        if (path.listFiles() != null) {
            for (File file : path.listFiles()) {
                    if (file.isFile()) {
                        filesCount++;
                    } else if (file.isDirectory()){
                        filesCount += calculateFiles(file.getPath());
                    }

            }
        }
        return filesCount;
    }

    public static int calculateDirs(String directoryPath) throws IOException {
        int dirsCount = 0;
        File path = new File(directoryPath);
        if (!path.exists()) {
            throw new IOException("Such path doesn't exist " + path);
        }
        if (path.listFiles() != null) {
            for (File dir : path.listFiles()) {
                if (dir.isDirectory()) {
                    dirsCount++;
                    dirsCount += calculateDirs(dir.getPath());
                }
            }
        }
        return dirsCount;
    }

    public static void copy(String from, String to) throws IOException {
        File pathFrom = new File(from);
        File pathTo = new File(to);
        if (!pathFrom.exists()) {
            throw new IOException("There is no such pathname from where you want to copy " + pathFrom);
        } else if (!pathTo.exists()) {
            pathTo.mkdirs();
        }
        if (pathFrom.isDirectory()) {
            for (File file : pathFrom.listFiles()) {
                if (file.isDirectory()) {
                    copy(file.getPath(), pathTo.getPath());
                } else {
                    fileCopy(file, new File(pathTo, file.getName()));
                }
            }
        }
    }

    public static void fileCopy (File from, File to) throws IOException {
        FileInputStream fromFile = null;
        FileOutputStream toFile = null;
        try {
            fromFile = new FileInputStream(from);
            toFile = new FileOutputStream(to);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fromFile.read(buffer)) != -1) {
                toFile.write(buffer, 0, bytesRead);
            }
        }
        finally {
            fromFile.close();
            toFile.close();
        }
    }

    public static void move(String from, String to) throws IOException {
        File pathFrom = new File(from);
        File pathTo = new File(to);
        if (!pathFrom.exists()) {
            throw new IOException("There is no such directory " + pathFrom.getName());
        } else if (!pathTo.exists()) {
            copy(from, to);
        }
        delete(from);
    }

    private static void delete(String from) {
        File dirToFelete = new File(from);
        for (File file : dirToFelete.listFiles()) {
            if (file.isDirectory()) {
                delete(file.getPath());
            }
            file.delete();
        }
        dirToFelete.delete();
    }

    public static void main(String[] args) throws IOException {
       System.out.println(FileManager.calculateFiles("C:\\Windows"));//190809
       System.out.println(FileManager.calculateDirs("C:\\Windows"));//44267
       System.out.println(FileManager.calculateFiles("C:\\Java"));//1519
       System.out.println(FileManager.calculateDirs("C:\\Java"));//136
    }

}
