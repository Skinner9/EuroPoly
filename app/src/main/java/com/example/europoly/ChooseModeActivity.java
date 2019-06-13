package com.example.europoly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ChooseModeActivity extends AppCompatActivity {
    AppState appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);
        appState = GlobalData.getInstance().appState;
    }
    public void hotseat(View view) {
        appState.mode = GameMode.HotSeat;
        Intent intent = new Intent(this, PlayerSettingsActivity.class);
        startActivity(intent);
    }
    public void multiplayer(View view) {
        appState.mode = GameMode.Multiplayer;
        Intent intent = new Intent(this, PlayerSettingsActivity.class);
        startActivity(intent);
    }
    public void back(View view) {
        onBackPressed();
    }
}
