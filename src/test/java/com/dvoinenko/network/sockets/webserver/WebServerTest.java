package com.dvoinenko.network.sockets.webserver;

import com.dvoinenko.draft.network.socket.webserver.WebServer;
import org.junit.Test;

import java.io.IOException;

public class WebServerTest {
    @Test
    public void serverTest() throws IOException {
        WebServer server = new WebServer();
        server.setServer(3000);
        server.setWebAppPath("src/main/resources/webapp");
        server.start();
    }
}