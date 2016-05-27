package com.useran.a30sec;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityDip extends AppCompatActivity implements OnClickListener {

    ImageView dipim;
    TextView dip, textTimer;
    ScrollView scroll;
    Button btnStart, Btnnext1, Btnback1;
    MyTimer mTimer;
    long remainMilli = 0;
    boolean isRunning=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dip);

        dip = (TextView) findViewById(R.id.dip);
        dipim = (ImageView) findViewById(R.id.dipim);
        scroll = (ScrollView) findViewById(R.id.scroll);
        btnStart = (Button)findViewById(R.id.btnStart);
        textTimer=(TextView)findViewById(R.id.textTimer);
        Btnnext1 = (Button)findViewById(R.id.Btnnext1);
        Btnback1 = (Button)findViewById(R.id.Btnback1);

        Btnnext1.setOnClickListener(this);
        Btnback1.setOnClickListener(this);

        btnStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRunning){
                    //cancel (pause) timer when it is running
                    mTimer.cancel();
                    mTimer=null;
                    isRunning=false;
                    btnStart.setText("Продолжить");
                }else{
                    if (remainMilli == 0) {
                        //start timer from initial time
                        mTimer = new MyTimer(1 * 1000 *60, 1000);
                    } else {
                        //resume timer from where it is paused
                        mTimer = new MyTimer(remainMilli, 1000);
                    }
                    btnStart.setText("Пауза");
                    mTimer.start();
                    isRunning=true;
                }
            }
        });

    }

    class MyTimer extends CountDownTimer {
        //constructor for timer class
        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        // this method called when timer is finished
        @Override
        public void onFinish() {
            // reset all variables
            textTimer.setText("");
            btnStart.setText("Начать");
            isRunning=false;
            remainMilli=0;
            final MediaPlayer mp = MediaPlayer.create(ActivityDip.this,R.raw.ding);
            mp.start();

            Toast toast = Toast.makeText(ActivityDip.this, "УПРАЖНЕНИЕ ВЫПОЛНЕНО!",Toast.LENGTH_SHORT);
            toast.show();
            toast.setGravity(Gravity.CENTER, 0,0);
        }
        //this method is called for every iteration of time interval
        @Override
        public void onTick(long millisUntilFinished) {
            remainMilli = millisUntilFinished;
            //calculate minutes and seconds from milliseconds
            String minute=""+(millisUntilFinished/1000)/60;
            String second=""+(millisUntilFinished/1000)%60;
            //apply style to minute and second
            if((millisUntilFinished/1000)/60<10)
                minute="0"+(millisUntilFinished/1000)/60;
            if((millisUntilFinished/1000)%60<10)
                second="0"+(millisUntilFinished/1000)%60;
            // update textview with remaining time
            textTimer.setText(minute+":"+second);
        }
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        scroll.scrollTo(0, 0);
        switch (v.getId()) {
            case R.id.Btnnext1:
                Intent intent = new Intent(this, ActivitySit.class);
                startActivity(intent);
                break;
            case R.id.Btnback1:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }

}
