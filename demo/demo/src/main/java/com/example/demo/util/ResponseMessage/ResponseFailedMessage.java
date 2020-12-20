package com.example.demo.util.ResponseMessage;


public class ResponseFailedMessage  extends ResponseMessage {
    public ResponseFailedMessage(String message) {
        super(0, null, message, 0);
    }
}
