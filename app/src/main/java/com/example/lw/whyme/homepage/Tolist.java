package com.example.lw.whyme.homepage;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

import com.example.lw.whyme.R;

/**
 * Created by LW on 2016/4/25.
 */
public class Tolist extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tolist);
    }
}
