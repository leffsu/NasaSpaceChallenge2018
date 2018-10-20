package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;
import android.content.Intent;

import com.nasaspacechallenge2018.Activity.Play2DActivity;
import com.nasaspacechallenge2018.Activity.Play3DActivity;
import com.nasaspacechallenge2018.Activity.SettingsActivity;
import com.nasaspacechallenge2018.Interface.MainActivityPresenterInterface;

public class MainActivityPresenter implements MainActivityPresenterInterface {

    Activity activity;

    public MainActivityPresenter(Activity activity){
        this.activity = activity;
    }

    @Override
    public void continueClick() {

    }

    @Override
    public void play2dClick() {
        Intent intent = new Intent(activity, Play2DActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void play3dClick() {
        Intent intent = new Intent(activity, Play3DActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void settingsClick() {
        Intent intent = new Intent(activity, SettingsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void exitClick() {

    }
}
