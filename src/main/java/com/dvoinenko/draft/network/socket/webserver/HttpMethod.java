package com.dvoinenko.draft.network.socket.webserver;

import java.util.NoSuchElementException;

enum  HttpMethod {
    GET, POST;

    HttpMethod getMethod (String methodName) {
        for (HttpMethod method : HttpMethod.values()) {
            if (methodName.equalsIgnoreCase(method.toString())) {
                return method;
            }
        }
        throw new NoSuchElementException("There is no such method");
    }
}
