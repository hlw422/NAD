package com.example.nad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nad.util.Utils;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //手动设置视图宽度
        TextView tv_code=findViewById(R.id.tv_code);
        ViewGroup.LayoutParams params=tv_code.getLayoutParams();
        params.width= Utils.dip2px(this,300);
        tv_code.setLayoutParams(params);


        Button btn=findViewById(R.id.JumpToFour);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        Button btn5=findViewById(R.id.JumpToFive);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,MainActivity5.class);
                startActivity(intent);
            }
        });
        Button btn6=findViewById(R.id.JumpToSix);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,MainActivity6.class);
                startActivity(intent);
            }
        });
    }
}