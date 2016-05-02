package com.example.lw.whyme.fragment;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.lw.whyme.Meeting.Meeting_Info;
import com.example.lw.whyme.Meeting.Toupiao;
import com.example.lw.whyme.R;

/**
 * Created by LW on 2016/4/16.
 */
public class ShouyeFragment extends Fragment implements View.OnClickListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab01, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.sign).setOnClickListener(this);
        getView().findViewById(R.id.contacts).setOnClickListener(this);
        getView().findViewById(R.id.date).setOnClickListener(this);
        getView().findViewById(R.id.tolist).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign:

                break;

            case R.id.contacts:
                Intent intent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
               startActivityForResult(intent,1);
                break;
            case R.id.date:
                try {
                    Intent i = new Intent();
                    ComponentName cn = null;
                    if (Integer.parseInt(Build.VERSION.SDK) >= 8) {
                        cn = new ComponentName("com.Android.calendar",
                                "com.android.calendar.LaunchActivity");

                    } else {
                        cn = new ComponentName("com.google.android.calendar",
                                "com.android.calendar.LaunchActivity");
                    }
                    i.setComponent(cn);
                    startActivity(i);
                } catch (ActivityNotFoundException e) {

                }
                break;

            case R.id.tolist:

                break;


        }

    }
}
