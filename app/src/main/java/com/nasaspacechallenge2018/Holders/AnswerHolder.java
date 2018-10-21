package com.nasaspacechallenge2018.Holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nasaspacechallenge2018.R;

public class AnswerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView testAnswer;
    private ClickAnswerListener clickAnswerListener;

    public AnswerHolder(@NonNull View itemView) {
        super(itemView);


        testAnswer = itemView.findViewById(R.id.text_answer);
        testAnswer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(clickAnswerListener != null)
            clickAnswerListener.onClickAnswer(getAdapterPosition());
    }

    public void setClickAnswerListener(ClickAnswerListener listener){
        this.clickAnswerListener = listener;
    }

    public interface ClickAnswerListener{
        void onClickAnswer(int pos);
    }
}
