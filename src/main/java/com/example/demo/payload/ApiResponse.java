package com.example.demo.payload;

public class ApiResponse {

    private boolean status;

    private String massage;

    public ApiResponse(boolean status, String massage) {
        this.status = status;
        this.massage = massage;
    }
}
