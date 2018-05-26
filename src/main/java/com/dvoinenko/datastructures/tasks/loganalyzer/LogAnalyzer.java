package com.dvoinenko.datastructures.tasks.loganalyzer;

import com.dvoinenko.datastructures.list.ArrayList;

import java.io.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogAnalyzer {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss");

    HttpMethod result;
    public ArrayList<LogToken> tokenSearch(String path, LocalDateTime timeFrom, LocalDateTime timeTo) throws IOException {
        ArrayList<LogToken> log = new ArrayList<>();
        BufferedReader bufferReader = new BufferedReader(new FileReader(new File(path)));
        try {
            String currentLine;
            while ((currentLine = bufferReader.readLine()) != null) {
                LogToken logToken = getToken(currentLine);
                if (logToken.getTime().isAfter(timeFrom) && logToken.getTime().isBefore(timeTo)) {
                    log.add(logToken);
                }
            }
        }

        finally {
            if (bufferReader != null) {
                bufferReader.close();
            }
        }
        return log;
    }

    private LogToken getToken(String line) {
        return new LogToken(readLocalDate(line), readHttpMethod(line), readMessage(line));
    }

    public LocalDateTime readLocalDate(String string) {
        int start = string.indexOf('[') + 1;
        int end = string.indexOf(' ', start);
        String stringLocalDate = string.substring(start, end);
        LocalDateTime localDateTime = LocalDateTime.parse(stringLocalDate, formatter.withLocale(Locale.US));
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
