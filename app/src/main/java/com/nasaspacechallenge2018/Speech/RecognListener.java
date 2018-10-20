package com.nasaspacechallenge2018.Speech;

public interface RecognListener {
    void onResult(String result);
    void onError(String error);
    void onStartListen();
    void onFinishListen();
}
