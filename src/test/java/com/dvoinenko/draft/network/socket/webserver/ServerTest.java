package com.dvoinenko.draft.network.socket.webserver;

import org.junit.Test;

import java.io.IOException;

public class ServerTest {
    @Test
    public void handleTest() throws IOException {
        Server server = new Server();
        server.setPort(3000);
        server.setWebappPath("C:\\Users\\Ivan\\IdeaProjects\\datastructures\\src\\main\\resources\\webapp");
        server.start();
    }

}