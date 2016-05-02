package com.example.lw.whyme;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by LW on 2016/4/25.
 */
public class Config {
    public static final  String Server_Url="192.168.1.1";
    //public static final  String Server_Url="http://baidu.com";
    public static final  String KEY_TOKEN="token";
    public static final  String APP_ID="Whyme";
     //获取缓存的token
    public static String getCachedToken(Context context){

         return context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).getString(KEY_TOKEN,null);
        //key和value  没有默认为null
    }

    //缓存token
    public  static void CachedToekn(Context context,String token){
        SharedPreferences.Editor e=context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).edit();
        e.putString(KEY_TOKEN,token);
        e.commit();
    }

}
