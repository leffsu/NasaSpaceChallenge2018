package com.nasaspacechallenge2018.Speech;

import com.nasaspacechallenge2018.Models.WitEntity;

import java.util.List;

public interface RecognListener {
    void onResult(List<WitEntity> result);
    void onError(String error);
    void onStartListen();
    void onFinishListen();
}
