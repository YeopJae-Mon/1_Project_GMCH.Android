package com.gmchproject.gmch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatus {
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NOT_CONNECTED = 3;

    public static int getConnectivityStatus(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo != null){
            int type = networkInfo.getType();
            if(type == ConnectivityManager.TYPE_MOBILE){  //데이터로 연결된것
                return TYPE_MOBILE;
            }else if(type == ConnectivityManager.TYPE_WIFI){  //와이파이 연결된것
                return  TYPE_WIFI;
            }
        }
        return TYPE_NOT_CONNECTED;  //데이터 미접속
    }
}
