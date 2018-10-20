package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;

import com.nasaspacechallenge2018.Holders.AnswerHolder;
import com.nasaspacechallenge2018.Interface.Play2DPresenterInterface;

public class Play2DPresenter implements Play2DPresenterInterface, AnswerHolder.ClickAnswerListener {

    private Activity activity;

    public Play2DPresenter(Activity activity){
        this.activity = activity;
    }

    @Override
    public void playTextSituation() {
        
    }

    @Override
    public void onClickAnswer(int pos) {

    }
}
