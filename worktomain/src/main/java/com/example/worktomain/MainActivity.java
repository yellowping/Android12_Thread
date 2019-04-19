package com.example.worktomain;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button btn;
    private MyHandler handler=new MyHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new ButtonListener());
    }
    class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
           NetworkThread thread=new NetworkThread();
           thread.start();
        }
    }
    class MyHandler extends android.os.Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        //    Log.e("线程--->>handleMessage",Thread.currentThread().getName());
            Log.e("线程--->>handleMessage"+Thread.currentThread().getName(),"ll");
            String s= (String) msg.obj;
            textView.setText(s);
        }
    }
    class NetworkThread extends Thread{
        @Override
        public void run() {
            Log.e("线程--->>Network",Thread.currentThread().getName());
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s="从网络中已经获取了数据";
            Message msg=handler.obtainMessage();
            msg.obj=s;
            msg.sendToTarget();
        }
    }

}
