package com.nasaspacechallenge2018.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;

import com.nasaspacechallenge2018.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HowToAssemblePrismActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_assemble_prism_activity);
        ButterKnife.bind(this);

        webView.loadUrl("https://www.drive2.ru/b/1915897/");

        webView.getSettings().setLoadsImagesAutomatically(true);
//        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Пирамида своими руками");
    }
}
