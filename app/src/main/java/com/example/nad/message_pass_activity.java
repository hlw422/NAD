package com.example.nad;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class message_pass_activity extends AppCompatActivity {
    private ActivityResultLauncher mLauncher; // 声明一个活动结果启动器对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_pass);

        TextView tv_msg = findViewById(R.id.tv_msg);
        Button btn_sendmsg = findViewById(R.id.send_msg);

        btn_sendmsg.setOnClickListener(this::onClick);


        mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle bundleResult = result.getData().getExtras();
                        String response_time = bundleResult.getString("response_time");
                        String response = bundleResult.getString("response");

                        String desc = String.format("响应时间: %s\n响应内容: %s\n", response_time, response);

                        TextView tv = findViewById(R.id.tv_msg);
                        tv.setText(desc);
                    }
                }
        );

        /*
        btn_sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String request = tv_msg.getText().toString();
                Intent intent = new Intent(message_pass_activity.this, MessageReceive.class);
                Bundle bundle = new Bundle();

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);
                bundle.putString("request_time", formattedDateTime);
                bundle.putString("request_content", request);
                intent.putExtras(bundle);
                //发送数据到其他activity
                //startActivity(intent);

                mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                                Bundle bundleResult = result.getData().getExtras();
                                String response_time = bundle.getString("response_time");
                                String response = bundle.getString("response");

                                String desc = String.format("响应时间: %s\n响应内容: %s\n", response_time, response);

                                TextView tv = findViewById(R.id.tv_receive);
                                tv.setText(desc);
                            }
                        }
                );


            }
        });
        */
    }
    public void onClick(View v){
        TextView tv_msg = findViewById(R.id.tv_msg);
        String request = tv_msg.getText().toString();
        Intent intent = new Intent(message_pass_activity.this, MessageReceive.class);
        Bundle bundle = new Bundle();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        bundle.putString("request_time", formattedDateTime);
        bundle.putString("request_content", request);
        intent.putExtras(bundle);

        mLauncher.launch(intent);
    }
}