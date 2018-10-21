package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;

import com.nasaspacechallenge2018.Adapter.AnswerAdapter;
import com.nasaspacechallenge2018.DBWork.ItemTable;
import com.nasaspacechallenge2018.DBWork.SituationTable;
import com.nasaspacechallenge2018.DBWork.SubSituationTable;
import com.nasaspacechallenge2018.Holders.AnswerHolder;
import com.nasaspacechallenge2018.Interface.Play2DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play2DPresenterInterface;
import com.nasaspacechallenge2018.Models.ItemModel;
import com.nasaspacechallenge2018.Models.SituationModel;
import com.nasaspacechallenge2018.Models.SubSituationModel;
import com.nasaspacechallenge2018.Speech.SpeechHelper;
import com.nasaspacechallenge2018.Utils.GameSound;
import com.nasaspacechallenge2018.Utils.PreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class SubsSituationPresenter implements Play2DPresenterInterface, AnswerHolder.ClickAnswerListener{

    private SpeechHelper speechHelper;
    private Play2DActivityInterface mvpActivity;
    private boolean isPlay;
    private SubSituationModel subsituation;
    private AnswerAdapter adapter;
    private ArrayList<ItemModel> itemModels;
    private int currentSituation;
    private int id;

    public SubsSituationPresenter(Play2DActivityInterface mvpActivity, int id){
        this.speechHelper = SpeechHelper.getInstance((Activity) mvpActivity);
        this.mvpActivity = mvpActivity;
        this.isPlay = false;
        this.itemModels = ItemTable.install((Activity)mvpActivity).getAll();
        this.currentSituation = 0;
        this.subsituation = SubSituationTable.install((Activity) mvpActivity).getSynonymsBySubSituationId(id);
        this.id = id;
        updateDate();
    }

    @Override
    public void playTextSituation(String text) {
        if(isPlay)
            speechHelper.sayPhrase(text);

    }

    @Override
    public void toNext() {

    }

    @Override
    public void onClickAnswer(int pos) {

        this.adapter.getItems().remove(pos);
        this.adapter.notifyDataSetChanged();
        if(this.adapter.getItems().size() == 0)
            mvpActivity.finishActivity();
//        updateDate();
    }

    private void updateDate(){
        if(currentSituation >= itemModels.size())
            return;

        List<ItemModel> items = ItemTable.install((Activity)mvpActivity).getItemsBySituatoinId(subsituation.getID());
        this.adapter = new AnswerAdapter((Activity) mvpActivity, items);
        this.adapter.setClickAnswerListener(this);
        this.mvpActivity.setAdapter(adapter);
        this.mvpActivity.setTextSituation(subsituation.getTITLE_SUB_SITUATION());
        this.mvpActivity.setImageSituation(PreferenceHelper.DRAWABLES[subsituation.getBACKGROUND_SUB_SITUATION()]);
    }
}
