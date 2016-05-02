package com.example.lw.whyme.erweima;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.lw.whyme.R;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

/**
 * Created by LW on 2016/4/15.
 */
public class Mqrcode extends Activity {
    private ImageView qrcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qrcode);
        qrcode=(ImageView)findViewById(R.id.img_erweima);
        //获取本地信息
        SharedPreferences pref=getSharedPreferences("phone",MODE_PRIVATE);
        String restore_num=pref.getString("phonenum","");
        //使用头像在二维码中间
        Bitmap bitmap= EncodingUtils.createQRCode(restore_num, 500, 500, BitmapFactory.decodeResource(getResources(), R.drawable.touxiang));


    }
}
