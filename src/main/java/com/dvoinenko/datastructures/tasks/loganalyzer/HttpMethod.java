package com.dvoinenko.datastructures.tasks.loganalyzer;

import java.io.Serializable;

enum HttpMethod implements Serializable {
    GET,
    POST;

    HttpMethod result;
    public HttpMethod getMethod(String method) {
        if (method.equals("GET")) {
            result = GET;
        } else if (method.equals("POST")) {
            result = POST;
        }
        return result;
    }

}
