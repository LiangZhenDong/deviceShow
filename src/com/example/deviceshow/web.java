package com.example.deviceshow;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Handler; 

public class web extends Activity {
	private WebView wv;
	private String url = "http://www.cqboston.cn";
	private ProgressDialog  progDlg;
	private  Handler handler;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		final WebView wv = (WebView) findViewById(R.id.wv);

		WebSettings webSettings = wv.getSettings();
		webSettings.setJavaScriptEnabled(true);
		// ���ÿ��Է����ļ�
		webSettings.setAllowFileAccess(true);
		// ����֧������
		webSettings.setBuiltInZoomControls(true);
		webSettings.setUseWideViewPort(true);//�P�I�c
		webSettings.setLoadWithOverviewMode(true);

		
		wv.setWebViewClient(new WebViewClient() {
	
			  public boolean onKeyDown(int keyCode,KeyEvent event) {  
			        if (keyCode == KeyEvent.KEYCODE_BACK &&wv.canGoBack()) {  
			        	wv.goBack();  
			            return true;  
			        } else  
			            return this.onKeyDown(keyCode, event);  
			    } 		

			  
			public boolean shouldOverrideUrlLoading(WebView webview, String url) {
				webview.loadUrl(url);
				return true; 
			}

			@Override
			public void onPageFinished(WebView webview, String url) {
				super.onPageFinished(webview, url);
			}

			@Override
			public void onPageStarted(WebView webview, String url,
					Bitmap favicon) {
				super.onPageStarted(webview, url,favicon);					
	            } 	
		});
		wv.loadUrl(url);

	}
}
