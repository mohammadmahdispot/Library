package com.example.demo.payload;

public class ApiResponse {

    private boolean status;
    private String massage;
    private Integer code;

    public ApiResponse(boolean status, String massage) {
        this.status = status;
        this.massage = massage;
    }

    public ApiResponse(boolean status, String massage, Integer code) {
        this.status = status;
        this.massage = massage;
        this.code = code;
    }
}
