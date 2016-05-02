package com.example.lw.whyme.erweima;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lw.whyme.R;
import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by LW on 2016/4/25.
 */
public class Decode extends Activity {
    private Button begin_decode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decode);
        begin_decode=(Button)findViewById(R.id.begin_decode);
        begin_decode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Decode.this, CaptureActivity.class);
                startActivityForResult(intent,0);
                //CaptureActivity返回数据到MainActivity中 所以用forResult
            }
        });

    }


    //扫描成功的操作  待完善
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //返回的数据放在Intent当中 再用bundle存储
        if(resultCode==RESULT_OK){
            Bundle bundle=data.getExtras();
            String result=bundle.getString("result");


        }
    }
}
