package com.dvoinenko.datastructures.tasks.loganalyzer;

import com.dvoinenko.datastructures.list.ArrayList;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogAnalyzer {
    public void tokenSearch(String path, LocalDateTime timeFrom, LocalDateTime timeTo) {

        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            ArrayList<LogToken> log = new ArrayList<>();
            String currentLine;
            while ((currentLine = bufferReader.readLine()) != null) {
                LocalDateTime local = readLocalDate(currentLine);
                String method = readHttpMethod(currentLine);
                String message = readMessage(currentLine);
                LogToken logToken = new LogToken(local, method, message);
                log.add(logToken);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public LocalDateTime readLocalDate(String string) {
        int start = string.indexOf('[') + 1;
        int end = string.indexOf(' ', start);
        String stringLocalDate = string.substring(start, end);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(stringLocalDate, formatter);
        return localDateTime;
    }

    public String readHttpMethod(String string) {
        int start = string.indexOf('"') + 1;
        int end = string.indexOf(' ', start);
        String stringHttpMethod = string.substring(start, end);
        return stringHttpMethod;
    }

    public String readMessage(String string) {
        int start = string.indexOf('/', string.indexOf('"'));
        int end = string.indexOf(string.length());
        String message = string.substring(start, end);
        return message;
    }

}
