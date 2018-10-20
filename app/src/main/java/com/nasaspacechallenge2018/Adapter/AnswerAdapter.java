package com.nasaspacechallenge2018.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nasaspacechallenge2018.Database.Item;
import com.nasaspacechallenge2018.Holders.AnswerHolder;
import com.nasaspacechallenge2018.Models.ItemModel;
import com.nasaspacechallenge2018.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerHolder> {

    public static AnswerHolder.ClickAnswerListener clickAnswerListener;
    private Activity activity;
    private ArrayList<ItemModel> items;

    public AnswerAdapter(Activity activity, List<ItemModel> items){
        this.activity = activity;
        this.items = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public AnswerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AnswerHolder(LayoutInflater.from(activity).inflate(R.layout.item_answer_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerHolder answerHolder, int i) {
        ItemModel item = items.get(i);
       /* if(item.getREQUIRED() == 1)
            answerHolder.itemView.setVisibility(View.GONE);
        else*/ {
            answerHolder.itemView.setVisibility(View.VISIBLE);
            answerHolder.testAnswer.setText(item.getNAME());
//            if(clickAnswerListener != null)
//                clickAnswerListener.onClickAnswer(i);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setClickAnswerListener(AnswerHolder.ClickAnswerListener listener){
        clickAnswerListener = listener;
    }
}
