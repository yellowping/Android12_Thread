package com.example.lunbo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Handler handler = new Handler();
    private int[] images = {
            R.drawable.shouye_top01, R.drawable.shouye_top02, R.drawable.shouye_top03
    };
    private int index;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imgView);

        handler.post(myRunnable);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(myRunnable);
            }
        });
    }
    private MyRunnable myRunnable = new MyRunnable();
    class MyRunnable implements Runnable{
        @Override
        public void run() {
            index++;
            index = index%3;
            imageView.setImageResource(images[index]);
            handler.postDelayed(myRunnable,1000);
        }
    }

}
