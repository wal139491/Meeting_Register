package com.example.lw.whyme.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lw.whyme.erweima.Mqrcode;
import com.example.lw.whyme.R;
import com.example.lw.whyme.personal_info.Zhuce;
import com.xys.libzxing.zxing.activity.CaptureActivity;

/**
 * Created by LW on 2016/4/16.
 */
public class XinxiFragment extends Fragment implements View.OnClickListener {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab04,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.zhuce).setOnClickListener(this);
        getView().findViewById(R.id.btn_file).setOnClickListener(this);
        getView().findViewById(R.id.btn_info).setOnClickListener(this);
        getView().findViewById(R.id.btn_setting).setOnClickListener(this);
        getView().findViewById(R.id.btn_shaomiao).setOnClickListener(this);
        getView().findViewById(R.id.btn_update).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
         case R.id.zhuce:
             Intent zhuIntent=new Intent(getActivity(),Zhuce.class);
             startActivity(zhuIntent);
             break;
         case R.id.Turn_Qr:
             Intent qrIntent=new Intent(getActivity(),Mqrcode.class);
             startActivity(qrIntent);
             break;
         case R.id.btn_file:

             break;
         case R.id.btn_info:

             break;
         case R.id.btn_setting:

             break;
         case R.id.btn_shaomiao:
             Intent Intent=new Intent(getActivity(),CaptureActivity.class);
             startActivityForResult(Intent, 0);
             //CaptureActivity返回数据到MainActivity中 所以用forResult
             break;

         case R.id.btn_update:

             break;

     }


    }

}
