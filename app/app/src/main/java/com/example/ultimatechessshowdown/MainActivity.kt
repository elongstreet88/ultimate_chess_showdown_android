package com.example.ultimatechessshowdown

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the WebView from the layout
        webView = findViewById(R.id.webView)

        // Enable JavaScript (optional, if required by the website)
        val webSettings = webView?.settings
        webSettings?.javaScriptEnabled = true

        // Enable WebView debugging (only for debugging purposes)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        // Set a custom WebViewClient to handle URL loading within the WebView
        webView?.webViewClient = MyWebViewClient()

        // Load the website URL
        webView?.loadUrl("http://localhost:5500/#48552fba-6e21-4e48-9f10-c0800013244f")
    }

    private class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            // This method is called when a new URL is about to be loaded.
            // Return false to let the WebView handle the URL internally and not open a browser.
            return false
        }
    }
}
