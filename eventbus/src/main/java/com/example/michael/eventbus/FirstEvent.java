package com.example.michael.eventbus;

/**
 * Created by Michael on 2016/5/17.
 */
public class FirstEvent {
    String msg;

    public FirstEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
