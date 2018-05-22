package com.dvoinenko.datastructures.tasks.loganalyzer;

import java.io.Serializable;

enum HttpMethod implements Serializable {
    GET,
    POST;


    public HttpMethod getMethod(String method) {
        HttpMethod result = null;
        if (method.toUpperCase().equals("GET")) {
            result = GET;
        } else if (method.toUpperCase().equals("POST")) {
            result = POST;
        }
        return result;
    }

}
