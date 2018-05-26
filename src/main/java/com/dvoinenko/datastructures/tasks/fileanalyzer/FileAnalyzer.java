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
        FileAnalyzer analyzer = new FileAnalyzer();
        analyzer.print(path, word);
        analyzer.count(path, word);
    }

    private void print(File path, String word) throws FileNotFoundException {
        Scanner scanner = new Scanner(path);
        StringBuilder fullText = new StringBuilder();
        StringBuilder sentences = new StringBuilder();
        while (scanner.hasNext()) {
            fullText.append(scanner.nextLine());
        }
        String[] splited =  fullText.toString().split("[.!?]\\s*");
        for (String line : splited) {
            if (line.contains(word)) {
                sentences.append(sentences);
                sentences.append("/n");
            }
        }
        System.out.println(sentences.toString());

    }

    private int count(File path, String word) throws FileNotFoundException {
        int count = 0;
        Scanner scanner = new Scanner(path);
        while (scanner.hasNext()) {
            String[] stringArray = scanner.nextLine().split(" ");
            for (String s : stringArray) {
                if (word.equals(s)) {
                    count++;
                }
            }
        }
        return count;
    }
}
