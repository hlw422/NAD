package com.example.nad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //设置字体颜色
        TextView textView_color=findViewById(R.id.tv_color);
        textView_color.setTextColor(Color.GREEN);
        //设置背景色
        textView_color.setBackgroundColor(Color.BLUE);
        //设置背景图片
        textView_color.setBackgroundResource(R.drawable.tt_s);

        Button btn=findViewById(R.id.clickMe);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}