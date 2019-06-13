package com.example.europoly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppState appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appState = GlobalData.getInstance().appState;
        setContentView(R.layout.activity_main);
    }
    public void newGame(View view) {
        Intent intent = new Intent(this, ChooseModeActivity.class);
        startActivity(intent);
    }
    public void resumeGame(View view) {

    }
    public void settings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    public void exit(View view) {
        finish();
    }
}
