package com.dvoinenko.datastructures.tasks.loganalyzer;

import com.dvoinenko.datastructures.list.ArrayList;

import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LogAnalyzer {

    HttpMethod result;
    public ArrayList<LogToken> tokenSearch(String path, LocalDateTime timeFrom, LocalDateTime timeTo) throws IOException {
        ArrayList<LogToken> log = new ArrayList<>();
        FileReader fileReader = new FileReader(new File(path));
        BufferedReader bufferReader = new BufferedReader(fileReader);
        try {
            String currentLine;
            while ((currentLine = bufferReader.readLine()) != null) {
                LocalDateTime inputDate = readLocalDate(currentLine);
                HttpMethod method = readHttpMethod(currentLine);
                String message = readMessage(currentLine);
                LogToken logToken = new LogToken(inputDate, method, message);
                if (inputDate.isAfter(timeFrom) && inputDate.isBefore(timeTo)) {
                    log.add(logToken);
                }
            }
        }

        finally {
            bufferReader.close();
            fileReader.close();
        }

        return log;
    }

    public LocalDateTime readLocalDate(String string) {
        int start = string.indexOf('[') + 1;
        int end = string.indexOf(' ', start);
        String stringLocalDate = string.substring(start, end);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(stringLocalDate, formatter);
        return localDateTime;
    }

    public HttpMethod readHttpMethod(String string) {
        int start = string.indexOf('"') + 1;
        int end = string.indexOf(' ', start);
        String stringHttpMethod = string.substring(start, end);
        return result.getMethod(stringHttpMethod);
    }

    public String readMessage(String string) {
        int start = string.indexOf('/', string.indexOf('"'));
        int end = string.indexOf(string.length());
        String message = string.substring(start, end);
        return message;
    }

    public static void main(String[] args) throws IOException {
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.tokenSearch("C:\\Users\\Ivan\\IdeaProjects\\datastructures\\target\\classes",
                LocalDateTime.of(2004, Month.MARCH, 07, 16, 24, 10),
                LocalDateTime.of(2004, Month.MARCH, 07, 16, 43, 30));
    }

}
