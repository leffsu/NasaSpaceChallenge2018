package com.nasaspacechallenge2018.Utils;

import android.content.Context;
import android.media.MediaPlayer;

import com.nasaspacechallenge2018.R;

public class GameSound {
    public interface GameSoundListener{
        void onFinished();
    }

    public static final int MUSIC_STEP_SNOW = 0;
    public static final int MUSIC_STEP = 1;
    public static final int MUSIC_SONG = 2;
    public static final int MUSIC_SONG_BASE = 3;
    public static final int MUSIC_CLICK = 4;

    private int[] musics = new int[]{
            R.raw.snow,
            R.raw.base,
            R.raw.song,
            R.raw.song_base,
            R.raw.zvuk_knopki_myshi
    };


    private MediaPlayer[] players;
    private Context context;
    private GameSoundListener listener;

    public GameSound(Context context){
        this.context = context;
        initPlayers();
    }

    private void initPlayers(){
        players = new MediaPlayer[musics.length];
    }

    public void play(final int music, float volume){
        players[music] = MediaPlayer.create(context, musics[music]);
        players[music].setVolume(volume,volume);
        players[music].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                players[music].start();
            }
        });
        players[music].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                players[music].release();
                if(listener != null)
                    listener.onFinished();
            }
        });
    }
    public void play(final int music){
        players[music] = MediaPlayer.create(context, musics[music]);
        players[music].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                players[music].start();
            }
        });
        players[music].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                players[music].release();
                if(listener != null)
                    listener.onFinished();
            }
        });
    }

    public void stop(int music){
        if(players[music] != null && players[music].isPlaying())
            players[music].stop();

    }

    public void setListener(GameSoundListener listener) {
        this.listener = listener;
    }
}
