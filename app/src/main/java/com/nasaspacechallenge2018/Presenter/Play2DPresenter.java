package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;

import com.nasaspacechallenge2018.Interface.Play2DPresenterInterface;

public class Play2DPresenter implements Play2DPresenterInterface {

    private Activity activity;

    public Play2DPresenter(Activity activity){
        this.activity = activity;
    }
}
