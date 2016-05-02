package com.example.lw.whyme.personal_info;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lw.whyme.R;
import com.example.lw.whyme.erweima.Mqrcode;

/**
 * Created by LW on 2016/4/14.
 */
public class Zhuce extends Activity {
    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private EditText edt4;
    private EditText edt5;
    private EditText edt6;
    private Button btn_zhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zhuce);
        edt1=(EditText)findViewById(R.id.editText);
        edt2=(EditText)findViewById(R.id.editText2);
        edt3=(EditText)findViewById(R.id.editText3);
        edt4=(EditText)findViewById(R.id.editText4);
        edt5=(EditText)findViewById(R.id.editText5);
        edt6=(EditText)findViewById(R.id.editText6);
        btn_zhu=(Button)findViewById(R.id.begin_zhuce);
        btn_zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=edt2.getText().toString();
                if(input.equals("")){
                    Toast.makeText(Zhuce.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    //本地文件名设置为phone
                    SharedPreferences.Editor editor=getSharedPreferences("phone",MODE_PRIVATE).edit();
                    editor.putString("phonenum",input);
                    editor.commit();
                    Toast.makeText(Zhuce.this, "注册成功", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}
