package com.example.michael.eventbus;

/**
 * Created by Michael on 2016/5/17.
 */
public class PostingEvent {
    String msg;

    public PostingEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
