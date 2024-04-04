package com.example.nad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String tag="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag,"onResume");
        goNextPage();
    }
    private void goNextPage(){
        TextView tv_hello=findViewById(R.id.tv_hello);
        tv_hello.setText("5秒后进入下个页面");
        new Handler(Looper.myLooper()).postDelayed(mGoNext,5000);
    }


    private Runnable mGoNext=new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(MainActivity.this,MainActivity2.class));
        }
    };
}