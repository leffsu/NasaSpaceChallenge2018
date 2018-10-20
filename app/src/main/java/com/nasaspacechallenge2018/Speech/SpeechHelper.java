package com.nasaspacechallenge2018.Speech;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import ru.yandex.speechkit.Emotion;
import ru.yandex.speechkit.Error;
import ru.yandex.speechkit.Language;
import ru.yandex.speechkit.OnlineModel;
import ru.yandex.speechkit.OnlineRecognizer;
import ru.yandex.speechkit.OnlineVocalizer;
import ru.yandex.speechkit.Recognition;
import ru.yandex.speechkit.Recognizer;
import ru.yandex.speechkit.RecognizerListener;
import ru.yandex.speechkit.SpeechKit;
import ru.yandex.speechkit.Synthesis;
import ru.yandex.speechkit.Track;
import ru.yandex.speechkit.Vocalizer;
import ru.yandex.speechkit.VocalizerListener;
import ru.yandex.speechkit.Voice;

public class SpeechHelper implements RecognizerListener, VocalizerListener {
    private static SpeechHelper instance;

    private static final int RC_RECORD_AUDIO = 842;

    private OnlineRecognizer recognizer;
    private OnlineVocalizer vocalizer;

    private VocalListener vocalListener;
    private RecognListener recognizerListener;

    private Activity activity;

    private String result = "";

    private SpeechHelper(Activity activity) {
        this.activity = activity;
        try {
            SpeechKit.getInstance().init(this.activity, "f3f1ea00-b67c-4a26-a558-b02857faa155");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SpeechKit.getInstance().setUuid("fb8cceed4c7d4260b885a495d264b2e2");

        recognizer = new OnlineRecognizer.Builder(Language.RUSSIAN, OnlineModel.QUERIES, this)
                .setDisableAntimat(false)
                .setEnablePunctuation(true)
                .build(); // 1
        recognizer.prepare(); // 2
        vocalizer = new OnlineVocalizer.Builder(Language.RUSSIAN, this)
                .setEmotion(Emotion.GOOD)
                .setVoice(Voice.ERMIL)
                .build(); // 1
        vocalizer.prepare();
    }

    public SpeechHelper getInstance(Activity activity) {
        if (instance == null)
            instance = new SpeechHelper(activity);
        return instance;
    }

    public void startListen() {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,new String[] {Manifest.permission.RECORD_AUDIO },RC_RECORD_AUDIO);
            return;
        }
        recognizer.startRecording();
        if(recognizerListener != null)
            recognizerListener.onStartListen();
    }

    public void onRequestPermissionAccess(int requestCode){
        if(requestCode == RC_RECORD_AUDIO) {
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
                return;

            recognizer.startRecording();
        }
    }

    public void sayPhrase(String text){
        vocalizer.synthesize(text,Vocalizer.TextSynthesizingMode.APPEND);
    }

    public void setVocalListener(VocalListener vocalListener) {
        this.vocalListener = vocalListener;
    }

    public void setRecognizerListener(RecognListener recognizerListener) {
        this.recognizerListener = recognizerListener;
    }

    @Override
    public void onRecordingBegin(@NonNull Recognizer recognizer) {

    }

    @Override
    public void onSpeechDetected(@NonNull Recognizer recognizer) {

    }

    @Override
    public void onSpeechEnds(@NonNull Recognizer recognizer) {

    }

    @Override
    public void onRecordingDone(@NonNull Recognizer recognizer) {
        if(!result.equals("")) {
            JsonObjectRequest request = new JsonObjectRequest(com.android.volley.Request.Method.GET,
                    "https://api.wit.ai/message?v=20181020&q=" + result, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if (response.getJSONObject("entities").keys().hasNext()) {
                            if (recognizerListener != null)
                                recognizerListener.onResult(response.getJSONObject("entities").keys().next());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (recognizerListener != null)
                        recognizerListener.onError(error.getMessage());
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("Authorization", "Bearer QP47R4MQ6IX4K36AYXQNHAAYEK54YI4R");
                    return map;
                }
            };
            Volley.newRequestQueue(activity).add(request);
        }
        else
            if(recognizerListener != null)
                recognizerListener.onFinishListen();
    }

    @Override
    public void onPowerUpdated(@NonNull Recognizer recognizer, float v) {

    }

    @Override
    public void onPartialResults(@NonNull Recognizer recognizer, @NonNull Recognition recognition, boolean b) {
        result = recognition.getBestResultText();
    }

    @Override
    public void onRecognitionDone(@NonNull Recognizer recognizer) {

    }

    @Override
    public void onRecognizerError(@NonNull Recognizer recognizer, @NonNull Error error) {

    }

    @Override
    public void onMusicResults(@NonNull Recognizer recognizer, @NonNull Track track) {

    }

    @Override
    public void onSynthesisDone(@NonNull Vocalizer vocalizer) {
        if(vocalListener != null)
            vocalListener.onFinishSpeak();
    }

    @Override
    public void onPartialSynthesis(@NonNull Vocalizer vocalizer, @NonNull Synthesis synthesis) {

    }

    @Override
    public void onPlayingBegin(@NonNull Vocalizer vocalizer) {

    }

    @Override
    public void onPlayingDone(@NonNull Vocalizer vocalizer) {

    }

    @Override
    public void onVocalizerError(@NonNull Vocalizer vocalizer, @NonNull Error error) {
        if(vocalListener != null)
            vocalListener.onError(error.toString());
    }
}
