package com.nasaspacechallenge2018.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.nasaspacechallenge2018.Interface.Play2DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play3DActivityInterface;
import com.nasaspacechallenge2018.Interface.Play3DPresenterInterface;
import com.nasaspacechallenge2018.Presenter.Play3DPresenter;
import com.nasaspacechallenge2018.R;


public class Play3DActivity extends AppCompatActivity implements Play3DActivityInterface {

    private Play3DPresenterInterface presenter;
    private ImageView leftImage, rightImage, topImage, bottomImage;
    private ImageView answerVoiceBtn;
    private ImageView playTextSituationBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play3d_layout);

        leftImage = findViewById(R.id.image_left_3d);
        rightImage = findViewById(R.id.image_right_3d);
        topImage = findViewById(R.id.image_top_3d);
        bottomImage = findViewById(R.id.image_bottom_3d);
        answerVoiceBtn = findViewById(R.id.voice_answer_btn);
        playTextSituationBtn = findViewById(R.id.repeat_text_situation);

        answerVoiceBtn.setOnClickListener(answerVoiceListener);
        playTextSituationBtn.setOnClickListener(playTextSituationListener);

//        int BOOKSHELF_ROWS = 3;
//        int BOOKSHELF_COLUMNS = 3;
//
//        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
//
//        for (int i = 0; i < BOOKSHELF_ROWS; i++) {
//
//            TableRow tableRow = new TableRow(this);
//            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
//                    TableLayout.LayoutParams.WRAP_CONTENT));
//            tableRow.setBackgroundResource(R.drawable.shelf);
//
//            for (int j = 0; j < BOOKSHELF_COLUMNS; j++) {
//                ImageView imageView = new ImageView(this);
//                imageView.setImageResource(R.drawable.book);
//
//                tableRow.addView(imageView, j);
//            }
//
//            tableLayout.addView(tableRow, i);
//        }
        presenter = new Play3DPresenter(this);
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
        if(isPlay) {
            answerVoiceBtn.setImageResource(R.mipmap.micro);
        }
        else {
            answerVoiceBtn.setImageResource(R.mipmap.micto_off);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void startSubSituationActivity(int idSubSituation) {
        Intent intent = new Intent(this, SubsSituation3DActivity.class);
        intent.putExtra("id", idSubSituation);
        startActivity(intent);
    }

    View.OnClickListener answerVoiceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) { ;
            presenter.recoverAnswer();
        }
    };

    View.OnClickListener playTextSituationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.playTextSituation();
        }
    };
}
