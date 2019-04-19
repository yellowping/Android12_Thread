package com.example.firsthandler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
   private Button btn;
   private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new ButtonListener());
        handler=new FirstHandler();
    }
    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
          //当用户点击按钮时，我们创建一个消息的对象。使用Handler把消息发送出去
            Message message=handler.obtainMessage();
            Person person=new Person(1,"黄平");
            //把2发送出去
          //  message.what=2;
            message.obj=person;
           // handler.sendMessage(message);
            message.sendToTarget();
            //上面一行代码将消息放入到消息队列中
            /**
             *1.Looper将从消息队列中将消息取出
             * 2.Looper将会找到与消息对象对应的Handler对象
             * 3.Looper将会调用Handler对象的HandlerMessage()方法处理消息
             */

        }
    }
    class FirstHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //把值取出来
            //int what=msg.what;
            Person person = (Person) msg.obj;
            Toast.makeText(MainActivity.this,"消息的内容是："+person,Toast.LENGTH_SHORT).show();
        }
    }
}
