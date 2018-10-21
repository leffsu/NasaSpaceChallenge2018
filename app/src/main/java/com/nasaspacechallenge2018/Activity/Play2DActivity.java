package com.nasaspacechallenge2018.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.nasaspacechallenge2018.Adapter.AnswerAdapter;
import com.nasaspacechallenge2018.Interface.Play2DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play2DPresenterInterface;
import com.nasaspacechallenge2018.Presenter.Play2DPresenter;
import com.nasaspacechallenge2018.R;
import com.nasaspacechallenge2018.Utils.GameSound;

public class Play2DActivity extends AppCompatActivity implements Play2DActivityInterface {

    private static final int RC_SUB_SITUATION = 94;

    Play2DPresenterInterface presenter;
    private TextView textSituation;
    private ImageView imageSituation;
    private RecyclerView listAnswer;
    private FloatingActionButton scrollDown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play2d_layout);

        textSituation = findViewById(R.id.text_quest_2d);
        imageSituation = findViewById(R.id.image_quest_2d);
        scrollDown = findViewById(R.id.scroll_down);

        listAnswer = findViewById(R.id.list_button);
        listAnswer.setLayoutManager(new LinearLayoutManager(this));
        listAnswer.setHasFixedSize(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        ((NestedScrollView)findViewById(R.id.scroll)).post(new Runnable() {
            @Override
            public void run() {
                ((NestedScrollView)findViewById(R.id.scroll)).scrollTo(0,0);
            }
        });

        presenter = new Play2DPresenter(this);
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
    public void setImageSituation(int drawable) {
        imageSituation.setImageResource(drawable);
    }

    @Override
    public void setAdapter(AnswerAdapter adapter) {
        listAnswer.setAdapter(adapter);
        ((NestedScrollView)findViewById(R.id.scroll)).post(new Runnable() {
            @Override
            public void run() {
                ((NestedScrollView)findViewById(R.id.scroll)).scrollTo(0,0);
            }
        });
    }

    @Override
    public void finishActivity() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SUB_SITUATION){
            presenter.toNext();
        }
    }

    @Override
    public void startSubSituationActivity(int idSubSituation) {

        Intent intent = new Intent(this,SubSituationActivity.class);
        intent.putExtra("id", idSubSituation);
        startActivityForResult(intent,RC_SUB_SITUATION);
    }
}
