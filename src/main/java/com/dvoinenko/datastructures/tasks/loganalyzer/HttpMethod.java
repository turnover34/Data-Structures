package com.dvoinenko.datastructures.tasks.loganalyzer;

enum HttpMethod {
    GET,
    POST,
    PUT,
    DELETE;

    public HttpMethod methodCheck(HttpMethod method) {
        switch (method) {
            case GET:
                method = GET;
                break;
            case POST:
                method = POST;
                break;
            case PUT:
                method = PUT;
                break;
            case DELETE:
                method = DELETE;
                break;
        }
        return method;
    }
}
