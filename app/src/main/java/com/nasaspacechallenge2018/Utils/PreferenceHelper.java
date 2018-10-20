package com.nasaspacechallenge2018.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private static PreferenceHelper instance;

    private final String IS_SOUND = "is_sound";
    private final String IS_SAVED = "is_saved";

    private SharedPreferences sharedPreferences;

    private PreferenceHelper(Context context){
        sharedPreferences = context.getSharedPreferences("polar_quest", Context.MODE_PRIVATE);
    }

    public static PreferenceHelper getInstance(Context context){
        if(instance == null)
            instance = new PreferenceHelper(context);
        return instance;
    }

    public boolean isSound(){
        return sharedPreferences.getBoolean(IS_SOUND,true);
    }

    public void setSound(boolean isSound){
        sharedPreferences.edit()
                .putBoolean(IS_SOUND, isSound)
                .apply();
    }

    public boolean isSaved(){
        return sharedPreferences.getBoolean(IS_SAVED, true);
    }

    public void setSaved(boolean isSaved){
        sharedPreferences.edit()
                .putBoolean(IS_SAVED, isSaved)
                .apply();
    }
}
