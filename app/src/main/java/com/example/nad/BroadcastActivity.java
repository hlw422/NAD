package com.example.nad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nad.util.DateUtil;

public class BroadcastActivity extends AppCompatActivity {
    TextView tv_standard=null;

    private  StandardReceiver standardReceiver;
    private  final static  String STANDARD_ACTION="com.example.nad.standard";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        tv_standard=findViewById(R.id.tv_standard);
        Button btn_send_broadcast=findViewById(R.id.btn_send_broadcast);
        btn_send_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(STANDARD_ACTION);
                intent.putExtra("ID","hello broad");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        standardReceiver=new StandardReceiver();
        IntentFilter filter=new IntentFilter(STANDARD_ACTION);
        registerReceiver(standardReceiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(standardReceiver);
    }

    private class StandardReceiver extends BroadcastReceiver{

        String desc="标准广播接收消息";
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent!=null&&intent.getAction().equals(STANDARD_ACTION)){
                String ID=intent.getStringExtra("ID");
                desc=String.format("接收到消息:%s\n%s", DateUtil.getNowTime(),ID);
                tv_standard.setText(desc);
            }
        }
    }
}