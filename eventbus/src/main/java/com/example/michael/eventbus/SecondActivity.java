package com.example.michael.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Michael on 2016/5/17.
 */
public class SecondActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void send(View view){
        String msg="你好，我来自第二个界面";
        MainMessage mainMessage=new MainMessage(msg);
        EventBus.getDefault().post(mainMessage);
    }
}
