package com.nasaspacechallenge2018.Activity;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nasaspacechallenge2018.Interface.Play2DPresenterInterface;
import com.nasaspacechallenge2018.Interface.Play3DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play3DPresenterInterface;
import com.nasaspacechallenge2018.Presenter.Play3DPresenter;
import com.nasaspacechallenge2018.Presenter.SubsSituation3DPresenter;
import com.nasaspacechallenge2018.R;

public class SubsSituation3DActivity extends AppCompatActivity implements Play3DActivityInterface {

    private Play3DPresenterInterface presenter;
    private ImageView leftImage, rightImage, topImage, bottomImage;
    private ImageView answerVoiceBtn;
    private ImageView playTextSituationBtn;
    private int idSubSituation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play3d_layout);

        idSubSituation = getIntent().getExtras().getInt("id");
        leftImage = findViewById(R.id.image_left_3d);
        rightImage = findViewById(R.id.image_right_3d);
        topImage = findViewById(R.id.image_top_3d);
        bottomImage = findViewById(R.id.image_bottom_3d);
        answerVoiceBtn = findViewById(R.id.voice_answer_btn);
        playTextSituationBtn = findViewById(R.id.repeat_text_situation);

        answerVoiceBtn.setOnClickListener(answerVoiceListener);
        playTextSituationBtn.setOnClickListener(playTextSituationListener);
        presenter = new SubsSituation3DPresenter(this, idSubSituation);
    }

    @Override
    public void setImage(Drawable drawable) {
        this.leftImage.setImageDrawable(drawable);
        this.rightImage.setImageDrawable(drawable);
        this.topImage.setImageDrawable(drawable);
        this.bottomImage.setImageDrawable(drawable);
    }

    @Override
    public void setVisibilityVoiceBtn(boolean isPlay) {

    }

    View.OnClickListener answerVoiceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.recoverAnswer();
        }
    };

    View.OnClickListener playTextSituationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.playTextSituation();
        }
    };

    @Override
    public void finishActivity() {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void startSubSituationActivity(int idSubSituation) {

    }
}
