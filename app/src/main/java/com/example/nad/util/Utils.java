package com.example.nad.util;

import android.content.Context;

public class Utils {

    //根据手机的分辨率从dp的单位转成px像素
    public static int dip2px(Context context,float dpValue){
        //获取屏幕像素密度
        float scale=context.getResources().getDisplayMetrics().density;
        return  (int)(dpValue*scale+0.5f);
    }
    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp(相对大小)
     */
    public static int pxToDp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
