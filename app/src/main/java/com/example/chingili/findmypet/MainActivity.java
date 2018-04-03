package com.example.chingili.findmypet;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private Runnable runnable;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        ((AnimationDrawable) img.getBackground()).start();  //封面動畫效果

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ChooseActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable, 4000);   // 4秒後自動跳轉
        img.setOnClickListener(listener);     //點擊跳轉

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent myIntent = new Intent();
            myIntent.setClass(MainActivity.this, ChooseActivity.class);
            startActivity(myIntent);
            handler.removeCallbacks(runnable);        //中斷動畫
            finish();
        }
    };

    private void findViews() {
        img = findViewById(R.id.img);
    }
}
