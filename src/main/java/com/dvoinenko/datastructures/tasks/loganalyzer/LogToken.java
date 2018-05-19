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

    private void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    private void setMethod(HttpMethod method) {
        this.method = method;
    }

    public HttpMethod getMethod() {
        return method;
    }

    private void setMassage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
