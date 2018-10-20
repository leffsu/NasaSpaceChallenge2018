package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;
import android.speech.RecognitionListener;

import com.nasaspacechallenge2018.Activity.Play2DActivity;
import com.nasaspacechallenge2018.Adapter.AnswerAdapter;
import com.nasaspacechallenge2018.Database.Situation;
import com.nasaspacechallenge2018.Holders.AnswerHolder;
import com.nasaspacechallenge2018.Interface.Play2DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play2DPresenterInterface;
import com.nasaspacechallenge2018.Speech.RecognListener;
import com.nasaspacechallenge2018.Speech.SpeechHelper;

public class Play2DPresenter implements Play2DPresenterInterface, AnswerHolder.ClickAnswerListener, RecognListener {

    private SpeechHelper speechHelper;
    private Play2DActivityInterface mvpActivity;
    private boolean isPlay;
    private Situation situation;
    private AnswerAdapter adapter;

    public Play2DPresenter(Play2DActivityInterface mvpActivity){
        this.speechHelper = SpeechHelper.getInstance((Activity) mvpActivity);
        this.mvpActivity = mvpActivity;
        this.isPlay = false;

        updateDate();
    }

    @Override
    public void playTextSituation(String text) {
        if(isPlay)
            speechHelper.sayPhrase(text);
    }

    @Override
    public void onClickAnswer(int pos) {

    }

    @Override
    public void onResult(String result) {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onStartListen() {

    }

    @Override
    public void onFinishListen() {

    }

    private void updateDate(){
        this.adapter = new AnswerAdapter((Activity) mvpActivity, situation.getItems());

        this.mvpActivity.setAdapter(adapter);
        this.mvpActivity.setTextSituation(situation.getCurrentComponentText());
//        this.mvpActivity.setImageSituation(situation.);
    }
}
