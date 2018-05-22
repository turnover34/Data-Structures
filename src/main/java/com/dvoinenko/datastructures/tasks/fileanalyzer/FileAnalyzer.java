package com.dvoinenko.datastructures.tasks.fileanalyzer;

/*
Написать программу FileAnalyzer, которая в консоли принимает 2 параметра:
        1) путь к файлу
        2) слово
        Usage:
        java FileAnalyzer C:/test/story.txt duck

        Выводит:
        1) Кол-во вхождений искомого слова в файле
        2) Все предложения содержащие искомое слово(предложение заканчивается символами ".", "?", "!"), каждое преждложение с новой строки.
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileAnalyzer {
    public static void main(String[] args) throws FileNotFoundException {
        File path = new File(args[0]);
        String word = args[1];
        int count = 0;
        Scanner scanner = new Scanner(path);
        StringBuilder stringBuilder = new StringBuilder();
        String data;
        while (scanner.hasNext()) {
            data = scanner.nextLine();
            if (data.contains(word)) {
                int marker;
                if (data.contains(".")) {
                    marker = data.indexOf(".");
                    stringBuilder.append(data).substring(0, marker);
                    stringBuilder.append("\n");
                } else if (data.contains("?")) {
                    marker = data.indexOf("?");
                    stringBuilder.append(data).substring(0, marker);
                    stringBuilder.append("\n");
                } else if (data.contains("!")) {
                    marker = data.indexOf("!");
                    stringBuilder.append(data).substring(0, marker);
                    stringBuilder.append("\n");
                }

                String[] line = data.split(" ");
                for (String simpleWord : line) {
                    if (simpleWord.equals(word)) {
                        count++;
                    }
                }
            }
        }

    }

}
