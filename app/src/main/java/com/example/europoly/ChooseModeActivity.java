package com.example.europoly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);
    }
    public void hotseat(View view) {
        Intent intent = new Intent(this, PlayerSettingsActivity.class);
        startActivity(intent);
    }
    public void multiplayer(View view) {
        Intent intent = new Intent(this, PlayerSettingsActivity.class);
        startActivity(intent);
    }
    public void back(View view) {
        onBackPressed();
    }
}
