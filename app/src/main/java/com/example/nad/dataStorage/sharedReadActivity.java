package com.example.nad.dataStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nad.R;

public class sharedReadActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_read);
        SharedPreferences shared=getSharedPreferences("share", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=shared.edit();

        EditText editTextName= findViewById(R.id.editTextName);
        EditText editTextAge= findViewById(R.id.editTextAge);
        EditText editTextHeight= findViewById(R.id.editTextHeight);
        EditText editTextWeight= findViewById(R.id.editTextWeight);
        CheckBox checkBox=findViewById(R.id.checkBoxMarried);

        Button btnSave=findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("name", String.valueOf(editTextName.getText()));
                editor.putInt("age",Integer.parseInt(String.valueOf(editTextAge.getText())));
                editor.putFloat("height",Float.parseFloat(String.valueOf(editTextHeight.getText())));
                editor.putFloat("weight",Float.parseFloat(String.valueOf(editTextWeight.getText())));
                editor.putBoolean("married", checkBox.isChecked());
                editor.commit();

                String desc=String.format(
                        "姓名：%s\n 年龄：%s\n身高:%s\n 体重：%s\n 已婚:%s ",
                        shared.getString("name",""),
                        shared.getInt("age",0),
                        shared.getFloat("height",0),
                        shared.getFloat("weight",0),
                        shared.getBoolean("married",false));


                Intent intent=new Intent(sharedReadActivity.this,ReadShardDataActivity.class);
                startActivity(intent);
              //Toast.makeText(sharedReadActivity.this,desc,Toast.LENGTH_LONG).show();
            }
        });
    }
}