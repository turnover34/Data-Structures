package com.dvoinenko.network.sockets.webserver;

import java.io.*;

public class ResourceReader {
    private String webappPath;

    public ResourceReader(String webappPath) {
        this.webappPath = webappPath;
    }

    public InputStream readContent(String resourcePath) throws FileNotFoundException {
        File file = new File(webappPath + resourcePath);
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }
}
