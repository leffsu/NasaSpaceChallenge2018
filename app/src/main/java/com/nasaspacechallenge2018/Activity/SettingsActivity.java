package com.nasaspacechallenge2018.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nasaspacechallenge2018.R;
import com.nasaspacechallenge2018.Utils.PreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {
    @BindView(R.id.swSaved)
    SwitchCompat swSaved;
    @BindView(R.id.swSound)
    SwitchCompat swSound;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initSwitch();
    }

    private void initSwitch() {
        final PreferenceHelper helper = PreferenceHelper.getInstance(this);
        swSound.setChecked(helper.isSound());
        swSaved.setChecked(helper.isSaved());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return true;
    }

    @OnCheckedChanged(R.id.swSound)
    public void onCheckedChangeSound(CompoundButton compoundButton, boolean isChecked){
        PreferenceHelper.getInstance(this).setSound(isChecked);
    }

    @OnCheckedChanged(R.id.swSaved)
    public void onCheckedChangeSaved(CompoundButton compoundButton, boolean isChecked){
        PreferenceHelper.getInstance(this).setSaved(isChecked);
    }

    @OnClick(R.id.txvShowGuide)
    public void onClickTxvShow(View v){
        Toast.makeText(this, "Rtr", Toast.LENGTH_LONG).show();
    }
}
