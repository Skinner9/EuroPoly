package com.example.europoly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void newGame(View view) {
        Intent intent = new Intent(this, ChooseModeActivity.class);
        startActivity(intent);
    }
    public void resumeGame(View view) {

    }
    public void settings(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }
    public void exit(View view) {
        finish();
    }
}
