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
import com.nasaspacechallenge2018.Utils.GameSound;
import com.nasaspacechallenge2018.Utils.PreferenceHelper;

import java.util.ArrayList;
import java.util.Arrays;
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
    private List<ItemModel> items;
    private GameSound gameSound;

    public Play3DPresenter(Play3DActivityInterface mvpActivity) {
        this.gameSound = new GameSound((Activity)mvpActivity);
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

        items = new ArrayList<>();
        if (subSituationModels.size() == 0)
            items.add(new ItemModel(0, situation.getID(), "Продолжить", "Продолжить", 0, "forward"));
        else {
            List<String> tempValues = Arrays.asList(situation.getCOMPONENT_TEXT_BASE().split(","));
            for (int i = 0; i <subSituationModels.size(); i++){
                //public ItemModel(int ID, int SITUATION_ID, String NAME, String ACTION, int REQUIRED, String SYNONYM)
                items.add(new ItemModel(subSituationModels.get(i).getID(), situation.getID(), tempValues.get(i), tempValues.get(i), 0, tempValues.get(i)));
            }
        }

        speechHelper.sayPhrase(situation.getMAIN_DESCRIPTION());

        gameSound.play(GameSound.MUSIC_STEP_SNOW,0.5f);
        mpvActivity.setImage(PreferenceHelper.DRAWABLES[situation.getBACKGROUND()]);
//        this.mvpActivity.setTextSituation(situation.getMAIN_DESCRIPTION());
//        this.mvpActivity.setImageSituation(situation.);
    }

    @Override
    public void playTextSituation() {
        speechHelper.sayPhrase(situation.getMAIN_DESCRIPTION());
    }

    @Override
    public void onResume() {
        speechHelper.setVocalListener(this);
        speechHelper.setRecognizerListener(this);
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
        mpvActivity.setVisibilityVoiceBtn(false);
        if (subSituationModels.size() != 0) {
            if(subSituationModels.get(0).getID() != 0) {
                for (int j = 0; j < subSituationModels.size(); j++) {
                    for (int i = 0; i < result.size(); i++) {
                        if (subSituationModels.get(j).getSYNONYM_SUB_SITUATION().contains(result.get(i).getValue())) {
                            mpvActivity.startSubSituationActivity(subSituationModels.get(j).getID());
                            subSituationModels.remove(j);
                            return;
                        }
                    }
                }
            }
            return;
        }

//        for (int i = 0; i < result.size(); i++) {
//            items.remove(result.get(i).getValue());
//        }

//        if (synonyms.size() == 0) {
        currentSituation++;
        updateDate();
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
        mpvActivity.setVisibilityVoiceBtn(true);
    }

    @Override
    public void onFinishListen() {
        mpvActivity.setVisibilityVoiceBtn(false);
    }
}
