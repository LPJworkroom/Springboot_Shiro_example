package com.example.demo.util.ResponseMessage;

public class ResponseMessage {
    public int status;  //1 for success,0 for failure
    public Object data; //query data
    public String message;  //brief description for result
    public int totalNum; //count of return data

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }


    public ResponseMessage() {
    }

    public ResponseMessage(int status, Object data, String message, int totalNum) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.totalNum = totalNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data){
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}


