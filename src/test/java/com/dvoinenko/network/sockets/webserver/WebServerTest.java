package com.dvoinenko.network.sockets.webserver;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WebServerTest {
    @Test
    public void serverTest() throws IOException {
        WebServer server = new WebServer();
        server.setServer(3000);
        server.setWebAppPath("src/main/resources/webapp");
        server.start();
    }
}