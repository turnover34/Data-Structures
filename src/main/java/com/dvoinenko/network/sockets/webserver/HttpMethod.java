package com.dvoinenko.network.sockets.webserver;

enum HttpMethod {
    GET, POST;

    public static HttpMethod getHttpMethod(String methodName) {
        for (HttpMethod httpMethod : HttpMethod.values()) {
            if (methodName.equalsIgnoreCase(httpMethod.toString())) {
                return httpMethod;
            }
        }
        throw new IllegalArgumentException("No such method!");
    }
}
