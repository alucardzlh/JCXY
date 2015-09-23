package com.example.alucard.jcxy.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;

import com.example.alucard.jcxy.R;

/**
 * Created by Alucard on 2015/8/28.
 */
public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        new Thread() {
            public void run() {
                SystemClock.sleep(3000);
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(intent);
                LoadingActivity.this.finish();
            }

        }.start();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }
}