package com.example.adityaladwa.unics;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintColor(getResources().getColor(R.color.primary));


        CheckInternet ci = new CheckInternet(this);
        boolean online = ci.isConnected();

        if (!online) {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_frame, new NoInternetFragment()).commit();

        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.my_frame, new WebFragment(), "webview").commit();
        }


    }

}
