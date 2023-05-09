package com.example.football6.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.football6.R

class WebActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val url = intent.getStringExtra("url")!!
        Toast.makeText(this,url,Toast.LENGTH_SHORT).show()

        webView = findViewById(R.id.id_webview)
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)


        webView.settings.javaScriptEnabled = true


        webView.settings.setSupportZoom(true)

    }

    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else finishAffinity()
    }

}