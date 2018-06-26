package com.dvoinenko.network.sockets.webserver;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ServerTest {

    @Test
    public void testServer() throws IOException {
        Server server = new Server();
        server.setPort(3000);
        server.setWebappPath("src/test/resources/webapp");
        server.start();
    }

}