package com.example.handlercallback;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 private Button btn;
 Handler handler=new Handler(new Handler.Callback() {
     @Override
     public boolean handleMessage(Message msg) {
         Toast.makeText(MainActivity.this,"第一个",Toast.LENGTH_SHORT).show();
         return false;
     }
 }){
     @Override
     public void handleMessage(Message msg) {
         super.handleMessage(msg);
         Toast.makeText(MainActivity.this,"第二个",Toast.LENGTH_SHORT).show();
     }
 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(1);
            }
        });
    }
}
