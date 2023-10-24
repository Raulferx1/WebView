package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JavaScriptInterface(),"appInterface");
    }
    public void loadURL(View view){
        EditText urlEditText = findViewById(R.id.txt_url);
        String url = urlEditText.getText().toString();
        if (url.isEmpty()){
            Toast.makeText(this,"ingrese una url valida", Toast.LENGTH_SHORT).show();
        }else{
            webView.loadUrl(url);
        }
    }


    private class JavaScriptInterface {
        @android.webkit.JavascriptInterface
        public void showToast(String message){

        }
    }
}