package com.example.myapp.TruyenRecycler.Activity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.Constants;
import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.model.TruyenAudio;

import java.util.ArrayList;

import static com.example.myapp.TruyenRecycler.Fragments.FragmentTruyenAudio.dsTruyenAudio;

public class ActivityTruyenAudioDetail extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener, MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private ImageView ivLove, ivShare, ivDownload, ivPre, ivPlay, ivNext, ivHome, ivRepeat, ivImageBack, ivImageAva;
    private TextView tvCurrentTime, tvTotalTime, tvTitle;
    private SeekBar seekBar;
    static ArrayList<TruyenAudio> listTruyen = new ArrayList<>();
    private int totaltime;
    private boolean isLike;
    boolean repeatFlag = false;
    boolean shuffle = false;
    private int position;
    private Thread thread;
    private Runnable runnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.truyen_audio_chi_tiet);
        initData();
        setWidget();
        initEvents();
        runnable = new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mediaPlayer.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int currentPosition = msg.what;
            // update position
            seekBar.setProgress(currentPosition);
            //update Label
            String elapsedTime = creatTimeLabel(currentPosition);
            tvCurrentTime.setText(elapsedTime);
            String remainingTime = creatTimeLabel(totaltime);
            tvTotalTime.setText(remainingTime);
        }
    };

    public void initData() {
        position = getIntent().getIntExtra(Constants.KEY_POSITION_TRUYEN_AUDIO, -1);
        listTruyen = dsTruyenAudio;
    }

    private void initEvents() {
        ivPlay.setOnClickListener(this);
        ivLove.setOnClickListener(this);
        ivShare.setOnClickListener(this);
        ivDownload.setOnClickListener(this);
        ivPre.setOnClickListener(this);
        ivNext.setOnClickListener(this);
        ivHome.setOnClickListener(this);
        ivRepeat.setOnClickListener(this);
        mediaPlayer.setOnCompletionListener(this);
        seekBar.setOnSeekBarChangeListener(this);
    }

    private void setWidget() {

        int idAudio = listTruyen.get(position).getIdAudio();
        mediaPlayer = MediaPlayer.create(ActivityTruyenAudioDetail.this, idAudio);
        ivPlay = findViewById(R.id.iv_play);
        ivPre = findViewById(R.id.iv_pre);
        ivNext = findViewById(R.id.iv_next);
        ivLove = findViewById(R.id.iv_love);
        ivShare = findViewById(R.id.iv_share);
        ivDownload = findViewById(R.id.iv_download);
        ivHome = findViewById(R.id.iv_home);
        ivRepeat = findViewById(R.id.iv_repeat);
        ivImageBack = findViewById(R.id.iv_truyen_big);
        ivImageAva = findViewById(R.id.iv_truyen_nho);
        tvCurrentTime = findViewById(R.id.tv_time_start);
        tvTotalTime = findViewById(R.id.tv_time_stop);
        tvTitle = findViewById(R.id.tv_title);

        ivImageBack.setImageResource(listTruyen.get(position).getIdImage());
        ivImageAva.setImageResource(listTruyen.get(position).getIdImage());
        tvTitle.setText(listTruyen.get(position).getTitle());
        initTime();
    }

    public void initTime() {
        mediaPlayer.seekTo(0);
        totaltime = mediaPlayer.getDuration();
        seekBar = findViewById(R.id.seekbar);
        seekBar.setMax(totaltime);
    }

    public void play() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            ivPlay.setImageResource(R.drawable.ic_play);
        } else {
            mediaPlayer.start();
            ivPlay.setImageResource(R.drawable.ic_pause);
        }
    }

    public void next() {

        if (mediaPlayer != null) {
            ivPlay.setImageResource(R.drawable.ic_play);
        }
        if (position < listTruyen.size() - 1) {
            position++;
        } else {
            mediaPlayer.stop();
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        ivImageBack.setImageResource(listTruyen.get(position).getIdImage());
        ivImageAva.setImageResource(listTruyen.get(position).getIdImage());
        tvTitle.setText(listTruyen.get(position).getTitle());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), listTruyen.get(position).getIdAudio());
        ivNext.setImageResource(R.drawable.ic_next_selected);
        ivPre.setImageResource(R.drawable.ic_pre);
        mediaPlayer.start();
        initTime();
        play();

    }

    public void pre() {

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            ivPlay.setImageResource(R.drawable.ic_play);
        }
        if (position > 0) {
            position--;
        } else {
            mediaPlayer.stop();
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        ivImageBack.setImageResource(listTruyen.get(position).getIdImage());
        ivImageAva.setImageResource(listTruyen.get(position).getIdImage());
        tvTitle.setText(listTruyen.get(position).getTitle());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), listTruyen.get(position).getIdAudio());
        ivPlay.setImageResource(R.drawable.ic_pause);
        ivPre.setImageResource(R.drawable.ic_pre_selected);
        ivNext.setImageResource(R.drawable.ic_nex);
        mediaPlayer.start();
        initTime();
        play();
        mediaPlayer.setOnCompletionListener(this);

    }

    public void love() {
        TruyenAudio truyen = listTruyen.get(position);
        isLike = truyen.getIsLike();
        if (mediaPlayer != null) {
            if (isLike) {
                Toast.makeText(this, "Đã loại bỏ khỏi danh sách truyện yêu thích", Toast.LENGTH_SHORT).show();
                ivLove.setImageResource(R.drawable.ic_love);
                isLike = false;
                listTruyen.get(position).setLike(isLike);

            } else {
                Toast.makeText(this, "Đã thêm vào danh sách truyện yêu thích ", Toast.LENGTH_SHORT).show();
                ivLove.setImageResource(R.drawable.ic_love_selectedpng);
                isLike = true;
                listTruyen.get(position).setLike(isLike);

            }
        }
    }

    public void repeat() {
        if (repeatFlag) {
            ivRepeat.setImageResource(R.drawable.ic_repeat);
            repeatFlag = false;
            mediaPlayer.setLooping(false);
        } else {
            ivRepeat.setImageResource(R.drawable.ic_repeat_one);
            repeatFlag = true;
            mediaPlayer.setLooping(true);
        }
    }

    public void onCompleteListener() {
        if (position < listTruyen.size() - 1) {
            position++;
        } else {
            mediaPlayer.stop();
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        ivImageBack.setImageResource(listTruyen.get(position).getIdImage());
        ivImageAva.setImageResource(listTruyen.get(position).getIdImage());
        tvTitle.setText(listTruyen.get(position).getTitle());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), listTruyen.get(position).getIdAudio());
        mediaPlayer.start();
        initTime();
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        onCompleteListener();
        // do something when the song is finished playing
        // for now we will just the change the pause icon to play icon
        ivPlay.setImageResource(R.drawable.ic_pause);

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // do something when the seekbar
        if (fromUser) {
            mediaPlayer.seekTo(progress); // seek the story
            seekBar.setProgress(progress);// set the seeekbar progress
            String elapsedTime = creatTimeLabel(progress);
            tvCurrentTime.setText(elapsedTime);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
//        mediaPlayer.seekTo(seekBar.getProgress());
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        // set seekbar maximum duration
        String total = creatTimeLabel(mediaPlayer.getDuration());
        tvTotalTime.setText(total);
        seekBar.setMax(mediaPlayer.getDuration());
        mediaPlayer.start();
        ivPlay.setImageResource(R.drawable.ic_pause);
    }

    private String creatTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;
        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;
        return timeLabel;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_play:
                play();
                break;
            case R.id.iv_home:
                finish();
                break;
            case R.id.iv_love:
                love();
                break;
            case R.id.iv_next:
                next();
                break;
            case R.id.iv_pre:
                pre();
                break;
            case R.id.iv_repeat:
                repeat();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (thread != null) {
            thread.interrupt();
        }
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

}


