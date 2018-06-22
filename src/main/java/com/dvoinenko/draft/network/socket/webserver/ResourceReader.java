package com.dvoinenko.draft.network.socket.webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResourceReader {
    private String resourcePath;

    public ResourceReader(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String readContent(String path) throws IOException {
        File file = new File(resourcePath + path);
        if (!file.exists()) {
            return "NOT_FOUND";
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                StringBuilder content = new StringBuilder();
                while((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append("\n");
                }
                return content.toString();
            }
        }
    }
}
