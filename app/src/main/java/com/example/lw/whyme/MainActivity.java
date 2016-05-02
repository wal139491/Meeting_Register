package com.example.lw.whyme;



import android.content.Intent;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;

import android.os.Bundle;

import android.view.View;
import android.view.Window;

import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.lw.whyme.fragment.DituFragment;
import com.example.lw.whyme.fragment.HuiyiFragment;
import com.example.lw.whyme.fragment.ShouyeFragment;
import com.example.lw.whyme.fragment.XinxiFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager mViewPager;
    private FragmentPagerAdapter madapter;

    private List<Fragment> mFragments; //Fragment作为adapter的数据源



    private LinearLayout mTabShouye;
    private LinearLayout mTabHuiyi;
    private LinearLayout mTabDitu;
    private LinearLayout mTabXinxi;
    private ImageButton mShouye;
    private ImageButton mHuiyi;
    private ImageButton mDitu;
    private ImageButton mXinxi;

    public int currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        String token=Config.getCachedToken(this);
        if(token!=null){

            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.main);
             initView();
            initEvent();

            setSelect(0);

        }else{
            startActivity(new Intent(this,Login.class));

        }
      finish();
    }
    private  void initEvent(){
        mShouye.setOnClickListener(this);
        mHuiyi.setOnClickListener(this);
        mDitu.setOnClickListener(this);
        mXinxi.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                currentItem = mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        mShouye.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mHuiyi.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mDitu.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mXinxi.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setSelect(int i)
    {
        setTab(i);
        mViewPager.setCurrentItem(i);
    }

    private void setTab(int i){
     //设置图片为亮色
     //切换内容区域
        resetImg();
     switch (i){

         case 0:
             mShouye.setImageResource(R.drawable.tab_weixin_pressed);
             break;
         case 1:
             mHuiyi.setImageResource(R.drawable.tab_find_frd_pressed);
             break;
         case 2:
             mDitu.setImageResource(R.drawable.tab_address_pressed);
             break;
         case 3:
             mXinxi.setImageResource(R.drawable.tab_settings_pressed);
             break;

         default:
             break;


     }
        mViewPager.setCurrentItem(i);

    }
    @Override
    public void onClick(View v) {

       switch (v.getId()){
           case R.id.tab_1_img:
              setSelect(0);

             break;
           case R.id.tab_2_img:
               setSelect(1);

               break;
           case R.id.tab_3_img:
               setSelect(2);

               break;
           case R.id.tab_4_img:
               setSelect(3);

               break;

           default:
               break;
       }
    }
   //将所有的图片变暗
    private void resetImg() {
      mShouye.setImageResource(R.drawable.tab_weixin_normal);
      mHuiyi.setImageResource(R.drawable.tab_find_frd_normal);
      mDitu.setImageResource(R.drawable.tab_address_normal);
      mXinxi.setImageResource(R.drawable.tab_settings_normal);
    }

    private void initView(){
        mViewPager=(ViewPager)findViewById(R.id.viewpager);

        //4个内容区域
        mTabShouye=(LinearLayout)findViewById(R.id.tab_1);
        mTabHuiyi=(LinearLayout)findViewById(R.id.tab_2);
        mTabDitu=(LinearLayout)findViewById(R.id.tab_3);
        mTabXinxi=(LinearLayout)findViewById(R.id.tab_4);
        //ImageButton
        mShouye=(ImageButton)findViewById(R.id.tab_1_img);
        mHuiyi=(ImageButton)findViewById(R.id.tab_2_img);
        mDitu=(ImageButton)findViewById(R.id.tab_3_img);
        mXinxi=(ImageButton)findViewById(R.id.tab_4_img);

        //Button

        mFragments = new ArrayList<Fragment>();
        Fragment mTab01=new ShouyeFragment();
        Fragment mTab02=new HuiyiFragment();
        Fragment mTab03=new DituFragment();
        Fragment mTab04=new XinxiFragment();

        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);

        madapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };




        mViewPager.setAdapter(madapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
