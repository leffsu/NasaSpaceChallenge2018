package com.nasaspacechallenge2018.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.nasaspacechallenge2018.Interface.MainActivityPresenterInterface;
import com.nasaspacechallenge2018.Presenter.MainActivityPresenter;
import com.nasaspacechallenge2018.R;

public class MainActivity extends AppCompatActivity {

    private Button settingsBtn, player2dBtn, player3dBtn, continueBtn, exitBtn;
    MainActivityPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);


        settingsBtn = findViewById(R.id.settings);
        player2dBtn = findViewById(R.id.play_2d);
        player3dBtn = findViewById(R.id.play_3d);
        continueBtn = findViewById(R.id.continue_btn);
        exitBtn = findViewById(R.id.exit);

        settingsBtn.setOnClickListener(settingsBtnListener);
        exitBtn.setOnClickListener(exitBtnListener);
        continueBtn.setOnClickListener(continueBtnListener);
        player2dBtn.setOnClickListener(play2DBtnListener);
        player3dBtn.setOnClickListener(play3dBtnListener);

    }

    View.OnClickListener settingsBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.settingsClick();
        }
    };

    View.OnClickListener continueBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.continueClick();
        }
    };

    View.OnClickListener exitBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.exitClick();
        }
    };

    View.OnClickListener play2DBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.play2dClick();
        }
    };

    View.OnClickListener play3dBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            presenter.play3dClick();
        }
    };

}
