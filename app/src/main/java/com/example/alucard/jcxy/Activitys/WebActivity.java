package com.example.alucard.jcxy.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.alucard.jcxy.R;

/**
 * Created by Alucard on 2015/8/21.
 */
public class WebActivity extends Activity implements OnClickListener {
     WebView web;
    Button back,menu;
    Intent intent;
    String URL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        URL="http://appzq.dichuang.cc/default.aspx";
        intent=getIntent();
        if(intent.getStringExtra("URL")!=null){
          URL=intent.getStringExtra("URL");
        }

        init();

    }


    void init(){
        web= (WebView) findViewById(R.id.webview);
        //web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDefaultTextEncodingName("UTF -8");
        web.setWebViewClient(new webViewClient());//设置链接页面内跳转
        web.setDownloadListener(new MyWebViewDownLoadListener());//设置该页面如果下载就启用系统IE下载
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);//JS
        //webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //webSettings.setAllowFileAccess(true);// 设置允许访问文件数据
       //webSettings.setSupportZoom(true);
        //webSettings.setBuiltInZoomControls(true);
        // webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //webSettings.setDomStorageEnabled(true);
        //webSettings.setDatabaseEnabled(true);
        web.loadUrl(URL);
        //web.loadData("","text/html","UTF-8");
        back= (Button) findViewById(R.id.back);
        menu= (Button) findViewById(R.id.menu);
        back.setOnClickListener(this);
        menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.menu:
                finish();
                break;
          default:
              break;
        }
    }


    class webViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

       /* @Override
        public void onPageFinished(WebView view, String url) {
            view.loadUrl("javascript:"+script);
            //super.onPageFinished(view, url);
        }*/
    }


    private class MyWebViewDownLoadListener implements DownloadListener {

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,
                                    long contentLength) {

            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish();
        }

        return false;
    }
}

