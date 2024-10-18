package com.devstudios.dbu.devstudios_dbu.application.dtos;

import java.util.Date;

public class ResponseDto<T> {

    private int status;
    private String message;
    private Date date = new Date();
    private T data;


    public ResponseDto(){}

    public ResponseDto(T data, int status, String message) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }



    

}
