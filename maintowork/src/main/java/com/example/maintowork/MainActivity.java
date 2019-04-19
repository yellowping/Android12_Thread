package com.example.maintowork;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private Button btn;
   private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkThread  thread=new WorkThread();
                thread.start();
                Message message=handler.obtainMessage();
                message.what=4;
                handler.sendMessage(message);
            }
        });
    }
    class WorkThread extends Thread{
        @Override
        public void run() {
            super.run();
            //做Looper的一个准备
            Looper.prepare();
            //实例化一个handler
            handler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    int what=msg.what;
                    Toast.makeText(MainActivity.this,what+"",Toast.LENGTH_SHORT).show();
                }
            };
            /**
             * 调用此方法，不断的从消息队列中取出消息
             * 如果有消息，就交由handleMessage()方法去处理
             * 如果没有消息,处理阻塞等待的状态
             */
            Looper.loop();
        }

    }
}
