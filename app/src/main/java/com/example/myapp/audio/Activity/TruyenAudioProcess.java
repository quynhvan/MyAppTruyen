//package com.example.myapp.audio.Activity;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.SeekBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapp.Constants;
//import com.example.myapp.R;
//import com.example.myapp.TruyenRecycler.model.TruyenAudio;
//
//import java.util.ArrayList;
//
//import static com.example.myapp.audio.Activity.ActivityTruyenAudio.dsTruyen;
//
//public class TruyenAudioProcess extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener {
//    private MediaPlayer mediaPlayer;
//    private ImageView ivLove, ivShare, ivDownload, ivPre, ivPlay, ivNext, ivHome, ivRepeat, ivImageBack, ivImageAva;
//    private TextView currentTime, totalTime,tvTitle;
//    private SeekBar seekBar;
//    private int currentIndex = 0;
//    static ArrayList<TruyenAudio> listTruyen = new ArrayList<>();
//    private int totaltime;
//    private int idAudio;
//    private boolean isLike;
//    private int position = -1;
//    private Handler handler = new Handler();
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.truyen_audio_chi_tiet);
//        initData();
//        setWidget();
//        initEvents();
//        seekbarListen();
//    }
//        private void initData() {
//        position = getIntent().getIntExtra(Constants.KEY_POSITION_TRUYEN_AUDIO,-1);
//        listTruyen = dsTruyen;
////        seekBar.setMax(mediaPlayer.getDuration());
//    }
//    private void initEvents() {
//        ivPlay.setOnClickListener(this);
//        ivLove.setOnClickListener(this);
//        ivShare.setOnClickListener(this);
//        ivDownload.setOnClickListener(this);
//        ivPre.setOnClickListener(this);
//        ivNext.setOnClickListener(this);
//        ivHome.setOnClickListener(this);
//        ivRepeat.setOnClickListener(this);
//    }
//
//    private void setWidget() {
//        int idAudio = listTruyen.get(position).getIdAudio();
//        mediaPlayer = MediaPlayer.create(TruyenAudioProcess.this, idAudio);
//        ivPlay = findViewById(R.id.iv_play);
//        ivPre = findViewById(R.id.iv_pre);
//        ivNext = findViewById(R.id.iv_next);
//        ivLove = findViewById(R.id.iv_love);
//        ivShare = findViewById(R.id.iv_share);
//        ivDownload = findViewById(R.id.iv_download);
//        ivHome = findViewById(R.id.iv_home);
//        ivRepeat = findViewById(R.id.iv_repeat);
//        ivImageBack = findViewById(R.id.iv_truyen_big);
//        ivImageAva = findViewById(R.id.iv_truyen_nho);
//        currentTime = findViewById(R.id.tv_time_start);
//        totalTime = findViewById(R.id.tv_time_stop);
//        seekBar = findViewById(R.id.seekbar);
//        tvTitle = findViewById(R.id.tv_title);
//        ivImageBack.setImageResource(listTruyen.get(position).getIdImage());
//        ivImageAva.setImageResource(listTruyen.get(position).getIdImage());
//        tvTitle.setText(listTruyen.get(position).getTitle());
//
//    }
//
//    public void play() {
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.pause();
//            ivPlay.setImageResource(R.drawable.ic_play);
//        } else {
//            mediaPlayer.start();
//            ivPlay.setImageResource(R.drawable.ic_pause);
//        }
//    }
//
//    public void next() {
//        if (mediaPlayer != null) {
//            ivPlay.setImageResource(R.drawable.ic_play);
//        }
//        if (currentIndex < listTruyen.size() - 1) {
//            currentIndex++;
//        } else {
//            mediaPlayer.stop();
//        }
//        if (mediaPlayer.isPlaying()) {
//            mediaPlayer.stop();
//        }
//        ivImageBack.setImageResource(listTruyen.get(currentIndex).getIdImage());
//        ivImageAva.setImageResource(listTruyen.get(currentIndex).getIdImage());
//        tvTitle.setText(listTruyen.get(currentIndex).getTitle());
//        mediaPlayer = MediaPlayer.create(getApplicationContext(), listTruyen.get(currentIndex).getIdAudio());
//        mediaPlayer.start();
//    }
//
//    public void pre() {
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.pause();
//            ivPlay.setImageResource(R.drawable.ic_play);
//        }
//        if (currentIndex > 0) {
//            currentIndex--;
//        } else {
//            mediaPlayer.stop();
//        }
//        if (mediaPlayer.isPlaying()) {
//            mediaPlayer.stop();
//        }
//        ivImageBack.setImageResource(listTruyen.get(currentIndex).getIdImage());
//        ivImageAva.setImageResource(listTruyen.get(currentIndex).getIdImage());
//        tvTitle.setText(listTruyen.get(currentIndex).getTitle());
//        mediaPlayer = MediaPlayer.create(getApplicationContext(), listTruyen.get(currentIndex).getIdAudio());
//        ivPlay.setImageResource(R.drawable.ic_pause);
//    }
//
//    public void onCompleteListener() {
//        if (currentIndex < listTruyen.size() - 1) {
//            currentIndex++;
//        } else {
//            mediaPlayer.stop();
//        }
//        if (mediaPlayer.isPlaying()) {
//            mediaPlayer.reset();
//        }
//        ivImageBack.setImageResource(listTruyen.get(currentIndex).getIdImage());
//        ivImageAva.setImageResource(listTruyen.get(currentIndex).getIdImage());
//        tvTitle.setText(listTruyen.get(currentIndex).getTitle());
//        mediaPlayer = MediaPlayer.create(getApplicationContext(), listTruyen.get(currentIndex).getIdAudio());
//        mediaPlayer.start();
//        mediaPlayer.setOnCompletionListener(this);
//
//    }
//    public void love() {
//        isLike = listTruyen.get(currentIndex).isLike();
//            if (mediaPlayer != null) {
//                if (isLike) {
//                    Toast.makeText(this, "Loại bỏ khỏi danh sách yêu thích", Toast.LENGTH_SHORT).show();
//                    ivLove.setImageResource(R.drawable.ic_love);
//                    isLike = false;
//                }
//                else{
//                    Toast.makeText(this, "Thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
//                    ivLove.setImageResource(R.drawable.ic_love_selectedpng);
//                    isLike = true;
//                 }
//             }
//    }
//    @Override
//    public void onCompletion(MediaPlayer mediaPlayer) {
//        onCompleteListener();
//        // do something when the song is finished playing
//        // for now we will just the change the pause icon to play icon
//        ivPlay.setImageResource(R.drawable.ic_play);
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.iv_play:
//                play();
//                break;
//            case R.id.iv_home:
//                finish();
//                break;
//            case R.id.iv_next:
//                next();
//                break;
//            case R.id.iv_pre:
//                pre();
//                break;
//            case R.id.iv_love:
//                love();
//                break;
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (mediaPlayer != null) {
//            mediaPlayer.release();
//        }
//    }
//
//    @Override
//    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//        if (fromUser && mediaPlayer!=null) {
//            mediaPlayer.seekTo(progress*1000); // seek the story
//            seekBar.setProgress(progress); // set the seeekbar progress
//        }
//    }
//
//    @Override
//    public void onStartTrackingTouch(SeekBar seekBar) {
//
//    }
//
//    @Override
//    public void onStopTrackingTouch(SeekBar seekBar) {
//
//    }
//
//    // setup seekbar to change with story duration
////    public void seekbarListen() {
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                while (mediaPlayer != null) {
////                    try {
////                        Message msg = new Message();
////                        msg.what = mediaPlayer.getCurrentPosition();
////                        handler.sendMessage(msg);
////                        Thread.sleep(1000);
////                    } catch (InterruptedException e) {
////
////                    }
////                }
////
////            }
////        }).start();
////
////    }
//    public void seekbarListen() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (mediaPlayer != null) {
//                    currentIndex = mediaPlayer.getCurrentPosition()/1000;
//                    seekBar.setProgress(currentIndex);
//                    currentTime.setText(formattedTime(currentIndex));
//                }
//                handler.postDelayed(this,1000);
//
//            }
//        }).start();
//
//    }
//    private String formattedTime(int currentIndex) {
//        String totalout = "";
//        String totalNew = "";
//        String seconds = String.valueOf(currentIndex % 60);
//        String minutes = String.valueOf(currentIndex / 60);
//        totalout = minutes + ":"+ seconds;
//        totalNew = minutes +":"+seconds;
//        if(seconds.length() == 1){
//            return totalNew;
//        }
//        else
//        {
//            return totalout;
//        }
//    }
//
////    @SuppressLint("HandlerLeak")
////    private Handler handler = new Handler() {
////        @Override
////        public void handleMessage(@NonNull Message msg) {
////            currentTime.setText(createTimeLabel(msg.what)); // set timer
////            seekBar.setProgress(msg.what);
////        }
////    };
////    public String createTimeLabel(int time) {
////        String timeLabel = "";
////        int min = time / 1000 / 60;
////        int sec = time / 1000 % 60;
////
////        timeLabel = min + ":";
////        if (sec < 10) timeLabel += "0";
////        timeLabel += sec;
////        return timeLabel;
////    }
////    public void onPrepared(MediaPlayer mediaPlayer) {
////        // set seekbar maximum duration
////
////        String toTime = createTimeLabel(mediaPlayer.getDuration());
////        totalTime.setText(toTime);
////
////        //start the story player
////        mediaPlayer.start();
////
////        //set icon to pause
////        ivPlay.setImageResource(R.drawable.ic_pause);
////    }
//}
//
//
