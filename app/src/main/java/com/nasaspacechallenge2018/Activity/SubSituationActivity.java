package com.nasaspacechallenge2018.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.nasaspacechallenge2018.Adapter.AnswerAdapter;
import com.nasaspacechallenge2018.Interface.Play2DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play2DPresenterInterface;
import com.nasaspacechallenge2018.Interface.SubsSituationPresenterInterface;
import com.nasaspacechallenge2018.Presenter.Play2DPresenter;
import com.nasaspacechallenge2018.Presenter.SubsSituationPresenter;
import com.nasaspacechallenge2018.R;

public class SubSituationActivity extends AppCompatActivity implements Play2DActivityInterface {

    Play2DPresenterInterface presenter;
    private TextView textSituation;
    private ImageView imageSituation;
    private RecyclerView listAnswer;
    private FloatingActionButton scrollDown;
    private int idSubSituation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play2d_layout);

        idSubSituation = getIntent().getExtras().getInt("id");

        textSituation = findViewById(R.id.text_quest_2d);
        imageSituation = findViewById(R.id.image_quest_2d);
        scrollDown = findViewById(R.id.scroll_down);

        listAnswer = findViewById(R.id.list_button);
        listAnswer.setLayoutManager(new LinearLayoutManager(this));
        listAnswer.setHasFixedSize(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        presenter = new SubsSituationPresenter(this, idSubSituation);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTextSituation(String text) {
        textSituation.setText(text);
    }

    @Override
    public void setImageSituation(Drawable drawable) {
        imageSituation.setImageDrawable(drawable);
    }

    @Override
    public void setAdapter(AnswerAdapter adapter) {
        listAnswer.setAdapter(adapter);
    }

    @Override
    public void finishActivity() {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void startSubSituationActivity(int idSubSituation) {

    }
}