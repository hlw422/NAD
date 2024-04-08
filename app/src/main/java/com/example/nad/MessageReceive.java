package com.example.nad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nad.util.DateUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageReceive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_receive);

        Bundle bundle=getIntent().getExtras();
        String request_time=bundle.getString("request_time");
        String request=bundle.getString("request_content");

        String desc=String.format("请求时间: %s\n请求内容: %s\n",request_time,request);

        TextView tv=findViewById(R.id.tv_receive);
        tv.setText(desc);

        Button btn_response=findViewById(R.id.btn_response);
        btn_response.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String response="天气不错";
                Intent intent = new Intent();
                Bundle bundle = new Bundle();


                bundle.putString("response_time", DateUtil.getNowFullDateTime());
                bundle.putString("response", response);
                intent.putExtras(bundle);

                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}