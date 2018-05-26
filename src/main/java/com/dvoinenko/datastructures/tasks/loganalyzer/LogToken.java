package com.dvoinenko.datastructures.tasks.loganalyzer;

import java.time.LocalDateTime;

class LogToken {
    private LocalDateTime time;
    private HttpMethod method;
    private String massage;

    public LogToken(LocalDateTime time, HttpMethod method, String massage) {
        this.time = time;
        this.method = method;
        this.massage = massage;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getMassage() {
        return massage;
    }
}
