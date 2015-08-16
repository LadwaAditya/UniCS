package com.example.adityaladwa.unics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by AdityaLadwa on 20-Apr-15.
 */
public class CheckInternet {
    private Context context;

    public CheckInternet(Context context) {
        super();
        this.context = context;
    }

    public boolean isConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

                }
            }

        }
        return false;

    }
}
