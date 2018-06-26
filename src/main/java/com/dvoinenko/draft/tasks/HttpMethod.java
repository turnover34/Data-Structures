package com.dvoinenko.draft.tasks;

public enum HttpMethod {
    GET, POST;

    public static HttpMethod getMethod(String stringMethod) {
        for (HttpMethod method : HttpMethod.values()) {
            if (stringMethod.equals(method.toString())) {
                return method;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HttpMethod method = HttpMethod.getMethod("PUT");
        System.out.println(method);
    }
}
