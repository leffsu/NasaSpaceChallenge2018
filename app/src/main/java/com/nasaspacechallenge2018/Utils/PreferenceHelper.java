package com.nasaspacechallenge2018.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.nasaspacechallenge2018.R;

public class PreferenceHelper {
    private static PreferenceHelper instance;

    private final String IS_SOUND = "is_sound";
    private final String IS_SAVED = "is_saved";

    public static int[] DRAWABLES = new int[]{
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9,
            R.drawable.a10,
            R.drawable.a11,
            R.drawable.a12,
            R.drawable.a13,
            R.drawable.a14,
            R.drawable.a15
    };

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
