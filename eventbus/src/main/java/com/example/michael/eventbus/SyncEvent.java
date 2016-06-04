package com.example.michael.eventbus;

/**
 * Created by Michael on 2016/5/17.
 */
public class SyncEvent {
    String msg;

    public SyncEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
