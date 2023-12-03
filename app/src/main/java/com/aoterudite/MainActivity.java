package com.aoterudite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    protected WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.MainWebView);

        initWebSettings(webView);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();

                if (url.equals("file:///android_asset/pages/categories/index.html")) {
                    view.loadUrl("file:///android_asset/pages/categories/index.html");
                }
                else if (url.equals("file:///android_asset/pages/settings/index.html")) {
                    view.loadUrl("file:///android_asset/pages/settings/index.html");
                }
                else {
                    return false;
                }

                return true;
            }
        });

        webView.loadUrl("file:///android_asset/index.html");
    }

    protected void initWebSettings(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript if needed
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
    }
}