package com.nasaspacechallenge2018.Interface;

import android.graphics.drawable.Drawable;

public interface Play3DActivityInterface {

    void setImage(int drawable);

    void setVisibilityVoiceBtn(boolean isPlay);
    void finishActivity();
    void startSubSituationActivity(int idSubSituation);
}
