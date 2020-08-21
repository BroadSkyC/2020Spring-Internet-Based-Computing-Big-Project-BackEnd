package com.example.rickymysql.bean;

import org.springframework.web.bind.annotation.ResponseBody;

public class LoginResponse {
    private boolean success;
    private String message;
    private Object content;

    public static LoginResponse buildSuccess(){
        LoginResponse response=new LoginResponse();
        response.setSuccess(true);
        return response;
    }

    public static LoginResponse buildSuccess(String message){
        LoginResponse response=new LoginResponse();
        response.setMessage(message);
        response.setSuccess(true);
        return response;
    }

    public static LoginResponse buildSuccess(Object content){
        LoginResponse response=new LoginResponse();
        response.setContent(content);
        response.setSuccess(true);
        return response;
    }

    public static LoginResponse buildFailure(String message){
        LoginResponse response=new LoginResponse();
        response.setMessage(message);
        response.setSuccess(false);
        System.out.println(message);
        return response;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
