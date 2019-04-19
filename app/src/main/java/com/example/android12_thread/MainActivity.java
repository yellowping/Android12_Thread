package com.example.android12_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
  private TextView textView;
  private Button btn;
  private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        progressBar=findViewById(R.id.progress);
        btn.setOnClickListener(new ButtonListener());
    }
    class  ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
//            NetWorkThread thread=new NetWorkThread();
//            thread.start();
            try {
                Thread.sleep(1*2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class NetWorkThread extends Thread{
        @Override
        public void run() {
            super.run();
            for(int i=1;i<100;i++) {
                try {
                    Thread.sleep(1 * 2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setProgress(progressBar.getProgress()+1);
                // textView.setText("从网络中获取信息");
            }
        }
    }
}
