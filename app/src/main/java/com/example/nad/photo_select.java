package com.example.nad;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nad.util.BitmapUtil;

public class photo_select extends AppCompatActivity {

    private ImageView iv_photo;
    private ActivityResultLauncher mLauncher; // 声明一个活动结果启动器对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_select);


        mLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri!=null) {
                        Bitmap bitmap= BitmapUtil.getAutoZoomImage(this,uri);
                        iv_photo.setImageBitmap(bitmap);
                    }
                }
        );

        iv_photo=findViewById(R.id.iv_photo);
        Button btn_common=findViewById(R.id.btn_choose_common);
        btn_common.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                * 这行代码创建了一个用于从设备中选择图片的意图(Intent)。它使用了Android系统提供的Intent.ACTION_PICK动作，指示系统打开一个用于选择特定类型数据的界面。在这种情况下，
                * 指定的数据类型是MediaStore.Images.Media.EXTERNAL_CONTENT_URI，表示选择的是存储在外部存储器中的图片文件。
                * */
                //Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                mLauncher.launch("image/*");
            }
        });
    }
}