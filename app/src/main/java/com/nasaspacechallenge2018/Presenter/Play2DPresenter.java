package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;
import android.speech.RecognitionListener;

import com.nasaspacechallenge2018.Activity.Play2DActivity;
import com.nasaspacechallenge2018.Adapter.AnswerAdapter;
import com.nasaspacechallenge2018.DBWork.DBConnect;
import com.nasaspacechallenge2018.DBWork.DBHelper;
import com.nasaspacechallenge2018.DBWork.ItemTable;
import com.nasaspacechallenge2018.DBWork.SituationTable;
import com.nasaspacechallenge2018.Database.Situation;
import com.nasaspacechallenge2018.Holders.AnswerHolder;
import com.nasaspacechallenge2018.Interface.Play2DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play2DPresenterInterface;
import com.nasaspacechallenge2018.Models.ItemModel;
import com.nasaspacechallenge2018.Models.SituationModel;
import com.nasaspacechallenge2018.Speech.RecognListener;
import com.nasaspacechallenge2018.Speech.SpeechHelper;

import java.util.ArrayList;
import java.util.List;

public class Play2DPresenter implements Play2DPresenterInterface, AnswerHolder.ClickAnswerListener{

    private SpeechHelper speechHelper;
    private Play2DActivityInterface mvpActivity;
    private boolean isPlay;
    private SituationModel situation;
    private AnswerAdapter adapter;
    private ArrayList<SituationModel> situationModels;
    private int currentSituation;

    public Play2DPresenter(Play2DActivityInterface mvpActivity){
        this.speechHelper = SpeechHelper.getInstance((Activity) mvpActivity);
        this.mvpActivity = mvpActivity;
        this.isPlay = false;
        this.situationModels = SituationTable.install((Activity)mvpActivity).getAll();
        this.currentSituation = 0;
        updateDate();
    }

    @Override
    public void playTextSituation(String text) {
        if(isPlay)
            speechHelper.sayPhrase(text);
    }

    @Override
    public void onClickAnswer(int pos) {
        currentSituation++;
        updateDate();
    }

    private void updateDate(){
        if(currentSituation >= situationModels.size())
            return;

        situation = situationModels.get(currentSituation);
        List<ItemModel> items = ItemTable.install((Activity)mvpActivity).getItemsBySituatoinId(situation.getID());
        if(items.size() == 0)
            items.add(new ItemModel(0, situation.getID(), "Продолжить", "Продолжить", 0, "forward"));
        this.adapter = new AnswerAdapter((Activity) mvpActivity, items);
        this.adapter.setClickAnswerListener(this);

        this.mvpActivity.setAdapter(adapter);
        this.mvpActivity.setTextSituation(situation.getMAIN_DESCRIPTION());
//        this.mvpActivity.setImageSituation(situation.);
    }
}
