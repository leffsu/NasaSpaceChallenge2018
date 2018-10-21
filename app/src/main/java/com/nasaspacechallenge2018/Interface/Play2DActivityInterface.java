package com.nasaspacechallenge2018.Interface;

import android.graphics.drawable.Drawable;

import com.nasaspacechallenge2018.Adapter.AnswerAdapter;

public interface Play2DActivityInterface {

    void setTextSituation(String text);
    void setImageSituation(int drawable);
    void setAdapter(AnswerAdapter adapter);
    void finishActivity();
    void startSubSituationActivity(int idSubSituation);
}
