package com.example.michael.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
//任务传递数据
public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.main_activity_tv);
        EventBus.getDefault().register(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEventBus(FirstEvent msg) {
        Log.d("MainActivity", "onMainEventBus returned: " + Thread.currentThread()+System.currentTimeMillis());//主线程5
        textView.setText(msg.getMsg());
    }    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void BackGroundEvent(BackGroundEvent msg) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("MainActivity", "BackGroundEvent returned: " + Thread.currentThread()+System.currentTimeMillis());//主线程5
        textView.setText(msg.getMsg());
    }    @Subscribe(threadMode = ThreadMode.POSTING)
    public void PostingEvent(PostingEvent msg) {
        Log.d("MainActivity", "PostingEvent returned: " + Thread.currentThread()+System.currentTimeMillis());//主线程5
        textView.setText(msg.getMsg());
    }    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void SyncEvent(SyncEvent msg) {
        Log.d("MainActivity", "SyncEvent returned: " + Thread.currentThread()+System.currentTimeMillis());//主线程5
        textView.setText(msg.getMsg());
    }




    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEventBus2(FirstEvent msg) {
        Log.d("MainActivity", "onEventBus() returned: " + Thread.currentThread());//主线程5
        textView.setText(msg.getMsg());
    }
 /*   public void open(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }   */
 public void open(View view){
       // startActivity(new Intent(this,SecondActivity.class));
    //主线程测试
     FirstEvent firstEvent=new FirstEvent("MainEvent");//
     EventBus.getDefault().post(firstEvent);
     Log.d("myevent",System.currentTimeMillis()+"");
 }
     public void open1(View view){
       // startActivity(new Intent(this,SecondActivity.class));
         BackGroundEvent backGroundEvent=new BackGroundEvent("BackGroundEvent");//
         EventBus.getDefault().post(backGroundEvent);
         Log.d("myevent",System.currentTimeMillis()+"");
    }
     public void open2(View view){
       // startActivity(new Intent(this,SecondActivity.class));
         PostingEvent postingEvent=new PostingEvent("PostingEvent");//
         EventBus.getDefault().post(postingEvent);
         Log.d("myevent",System.currentTimeMillis()+"");
    }
     public void open3(View view){
       // startActivity(new Intent(this,SecondActivity.class));
         SyncEvent SyncEvent=new SyncEvent("SyncEvent");//
         EventBus.getDefault().post(SyncEvent);
         Log.d("myevent",System.currentTimeMillis()+"");
    }

}
