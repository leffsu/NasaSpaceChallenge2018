package com.nasaspacechallenge2018.Presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import com.nasaspacechallenge2018.Activity.Play2DActivity;
import com.nasaspacechallenge2018.Activity.Play3DActivity;
import com.nasaspacechallenge2018.Activity.SettingsActivity;
import com.nasaspacechallenge2018.Interface.MainActivityPresenterInterface;
import com.nasaspacechallenge2018.R;

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
        getDialogExit().show();
    }

    private Dialog getDialogExit(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle(activity.getResources().getString(R.string.exit));
        dialog.setMessage(activity.getResources().getString(R.string.are_u_sure));
        dialog.setPositiveButton(activity.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finish();
            }
        });
        dialog.setPositiveButton(activity.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return dialog.create();
    }
}
