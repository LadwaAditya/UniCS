package com.example.adityaladwa.unics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by AdityaLadwa on 20-Apr-15.
 */
public class WebFragment extends Fragment {
    private WebView web;
    private WebSettings webSettings;
    private static final String URL = "http://cse.bietdvg.edu/unics/";


    public WebFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.weblayout, container, false);



        web = (WebView) rootView.findViewById(R.id.my_webview);
        WebSettings();
        web.setWebViewClient(new WebViewClient());
        web.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        web.loadUrl(URL);

        web.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
                    web.goBack();
                    return true;
                }
                return false;
            }
        });

        return rootView;
    }

    public void WebSettings() {
        webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

    }


}
