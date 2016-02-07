package com.emotionalcode.brave;

import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MissionActivity extends AppCompatActivity {

    private static final int PHOTO_TAKEN_REQUEST_CODE = 123;
    private TextView timerTextView;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        timer = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)));
            }

            @Override
            public void onFinish() {
                missionTimeout();
            }
        };
    }

    private void missionTimeout() {
        Toast.makeText(this, "Mission Failed!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_TAKEN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Mission Done !!!", Toast.LENGTH_LONG).show();
            } else {
                missionTimeout();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        timer.start();
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    public void doMission(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, PHOTO_TAKEN_REQUEST_CODE);
    }
}
