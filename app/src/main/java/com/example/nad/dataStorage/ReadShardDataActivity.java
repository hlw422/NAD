package com.example.nad.dataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nad.R;

public class ReadShardDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_shard_data);

        SharedPreferences shared = getSharedPreferences("share", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        Button btnJumpToLogin=findViewById(R.id.btnJumpToLogin);
        btnJumpToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ReadShardDataActivity.this,LoginRemeberActivity.class);
                startActivity(intent);
            }
        });

        Button btnSave = findViewById(R.id.btnRead);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String desc = String.format(
                        "姓名：%s\n 年龄：%s\n身高:%s\n 体重：%s\n 已婚:%s ",
                        shared.getString("name", ""),
                        shared.getInt("age", 0),
                        shared.getFloat("height", 0),
                        shared.getFloat("weight", 0),
                        shared.getBoolean("married", false));

                Toast.makeText(ReadShardDataActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });
    }
}