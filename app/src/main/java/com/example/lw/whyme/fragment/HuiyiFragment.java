package com.example.lw.whyme.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lw.whyme.Meeting.Meeting_Info;
import com.example.lw.whyme.R;
import com.example.lw.whyme.Meeting.Toupiao;

/**
 * Created by LW on 2016/4/17.
 */
public class HuiyiFragment extends Fragment implements View.OnClickListener {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab02, container, false);

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.meet_info).setOnClickListener(this);
        getView().findViewById(R.id.meet_toupiao).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.meet_info:
                Intent zhuIntent = new Intent(getActivity(), Meeting_Info.class);
                startActivity(zhuIntent);
                break;
            case R.id.meet_toupiao:
                Intent qrIntent = new Intent(getActivity(), Toupiao.class);
                startActivity(qrIntent);
                break;

        }
    }
}
