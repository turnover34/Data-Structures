package com.dvoinenko.datastructures.tasks.loganalyzer;

import java.time.LocalDateTime;

class LogToken {
    private LocalDateTime time;
    private String method;
    private String massage;

    public LogToken(LocalDateTime time, String method, String massage) {
        this.time = time;
        this.method = method;
        this.massage = massage;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
