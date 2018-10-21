package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;

import com.nasaspacechallenge2018.Adapter.AnswerAdapter;
import com.nasaspacechallenge2018.DBWork.ItemTable;
import com.nasaspacechallenge2018.DBWork.SituationTable;
import com.nasaspacechallenge2018.DBWork.SubSituationTable;
import com.nasaspacechallenge2018.Database.Item;
import com.nasaspacechallenge2018.Interface.Play3DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play3DPresenterInterface;
import com.nasaspacechallenge2018.Models.ItemModel;
import com.nasaspacechallenge2018.Models.SituationModel;
import com.nasaspacechallenge2018.Models.SubSituationModel;
import com.nasaspacechallenge2018.Models.WitEntity;
import com.nasaspacechallenge2018.Speech.RecognListener;
import com.nasaspacechallenge2018.Speech.SpeechHelper;
import com.nasaspacechallenge2018.Speech.VocalListener;

import java.util.ArrayList;
import java.util.List;

public class Play3DPresenter implements Play3DPresenterInterface, RecognListener, VocalListener {

    private Play3DActivityInterface mpvActivity;
    private ArrayList<SituationModel> situationModels;
    private int currentSituation;
    private int subCurrentSituation;
    private SituationModel situation;
    private ArrayList<String> synonyms;
    private SpeechHelper speechHelper;
    private ArrayList<SubSituationModel> subSituationModels;

    public Play3DPresenter(Play3DActivityInterface mvpActivity) {
        this.mpvActivity = mvpActivity;
        this.situationModels = SituationTable.install((Activity) mvpActivity).getAll();
        this.currentSituation = 0;
        this.subSituationModels = new ArrayList<>();
        this.speechHelper = SpeechHelper.getInstance((Activity) mvpActivity);
        this.speechHelper.setRecognizerListener(this);
        this.speechHelper.setVocalListener(this);
        updateDate();
    }

    private void updateDate() {
        if (currentSituation >= situationModels.size())
            return;

        situation = situationModels.get(currentSituation);
        subSituationModels = SubSituationTable.install((Activity) mpvActivity).getSubSituationBySituationId(situation.getID());

        List<ItemModel> items = new ArrayList<>();
        if (subSituationModels.size() == 0)
            items.add(new ItemModel(0, situation.getID(), "Продолжить", "Продолжить", 0, "forward"));

        speechHelper.sayPhrase(situation.getMAIN_DESCRIPTION());

//        mpvActivity.setImage();
//        this.mvpActivity.setTextSituation(situation.getMAIN_DESCRIPTION());
//        this.mvpActivity.setImageSituation(situation.);
    }

    @Override
    public void playTextSituation() {
        speechHelper.sayPhrase(situation.getMAIN_DESCRIPTION());
    }

    @Override
    public void playValuesAnswer() {
        //todo подсказка
    }

    @Override
    public void recoverAnswer() {
        speechHelper.startListen();
    }

    @Override
    public void toNext() {
        subSituationModels.remove(subCurrentSituation);
        if(subSituationModels.size() == 0){
            currentSituation++;
            updateDate();
        }
    }

    @Override
    public void onResult(List<WitEntity> result) {
//        if (items.size() != 0) {
//
//            if(items.get(0).getID() != 0) {
//                for (int j = 0; j < items.size(); j++) {
//                    for (int i = 0; i < result.size(); i++) {
//                        if (items.get(j).getSYNONYM_SUB_SITUATION().equals(result.get(i).getValue()))
//                            mpvActivity.startSubSituationActivity(items.get(i).getID());
//                    }
//                }
//            }
//            return;
//        }
//
//        for (int i = 0; i < result.size(); i++) {
//            items.remove(result.get(i).getValue());
//        }
//
//        if (synonyms.size() == 0) {
//            currentSituation++;
//            updateDate();
//        }
    }

    @Override
    public void onFinishSpeak() {
        speechHelper.startListen();
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
}
