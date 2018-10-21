package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;

import com.nasaspacechallenge2018.Adapter.AnswerAdapter;
import com.nasaspacechallenge2018.DBWork.ItemTable;
import com.nasaspacechallenge2018.DBWork.SituationTable;
import com.nasaspacechallenge2018.DBWork.SubSituationTable;
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

public class SubsSituation3DPresenter implements Play3DPresenterInterface, RecognListener, VocalListener {

    private Play3DActivityInterface mpvActivity;
    private int currentSituation;
    private List<ItemModel> itemsModels;
    private SpeechHelper speechHelper;
    private SubSituationModel subsituation;
    private int id;

    public SubsSituation3DPresenter(Play3DActivityInterface mvpActivity, int id){
        this.mpvActivity = mvpActivity;
//        this.situationModels = SituationTable.install((Activity)mvpActivity).getAll();
        this.currentSituation = 0;
        this.speechHelper = SpeechHelper.getInstance((Activity)mvpActivity);
        this.speechHelper.setRecognizerListener(this);
        this.speechHelper.setVocalListener(this);
        this.itemsModels = ItemTable.install((Activity)mvpActivity).getAll();
        this.subsituation = SubSituationTable.install((Activity) mvpActivity).getSynonymsBySubSituationId(id);
        this.id = id;
        updateDate();
    }

    private void updateDate(){
        if(currentSituation >= itemsModels.size())
            return;


        itemsModels = ItemTable.install((Activity)mpvActivity).getItemsBySituatoinId(subsituation.getID());
//
//        if(items.size() == 0)
//            items.add(new ItemModel(0, situation.getID(), "Продолжить", "Продолжить", 0, "forward"));

        speechHelper.sayPhrase(subsituation.getTITLE_SUB_SITUATION());




//        mpvActivity.setImage();
//        this.mvpActivity.setTextSituation(situation.getMAIN_DESCRIPTION());
//        this.mvpActivity.setImageSituation(situation.);
    }

    @Override
    public void playTextSituation() {
        speechHelper.sayPhrase(subsituation.getTITLE_SUB_SITUATION());
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

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onResult(List<WitEntity> result) {
        mpvActivity.setVisibilityVoiceBtn(false);
        if (itemsModels.size() != 0) {
            if(itemsModels.get(0).getID() != 0) {
                for (int i = 0; i < result.size(); i++) {
                    for (int j = 0; j < itemsModels.size(); j++) {
                        if (itemsModels.get(j).getSYNONYM().contains(result.get(i).getValue())) {
                            itemsModels.remove(j);
                            j--;
                        }
                    }
                }
            }
        }

        if(itemsModels.size() == 0)
            mpvActivity.finishActivity();
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
        mpvActivity.setVisibilityVoiceBtn(true);
    }

    @Override
    public void onFinishListen() {
        mpvActivity.setVisibilityVoiceBtn(false);
    }
}
