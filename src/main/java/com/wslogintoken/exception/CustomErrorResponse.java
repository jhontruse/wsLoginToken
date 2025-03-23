package com.wslogintoken.exception;

import java.time.LocalDateTime;
import java.util.Objects;

public class CustomErrorResponse {

    private LocalDateTime datetime;
    private String message;
    private String details;

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public CustomErrorResponse(LocalDateTime datetime, String message, String details) {
        this.datetime = datetime;
        this.message = message;
        this.details = details;
    }

    public CustomErrorResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomErrorResponse that = (CustomErrorResponse) o;
        return Objects.equals(datetime, that.datetime) && Objects.equals(message, that.message) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datetime, message, details);
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" +
               "datetime=" + datetime +
               ", message='" + message + '\'' +
               ", details='" + details + '\'' +
               '}';
    }
}
