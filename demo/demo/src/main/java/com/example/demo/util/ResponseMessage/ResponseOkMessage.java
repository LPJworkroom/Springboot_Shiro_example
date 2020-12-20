package com.example.demo.util.ResponseMessage;

public class ResponseOkMessage extends ResponseMessage{
    public ResponseOkMessage(Object data, int totalNum) {
        super(1, data,null, totalNum);
    }
    public ResponseOkMessage() {
        super(1,null,null ,0);
    }
}
