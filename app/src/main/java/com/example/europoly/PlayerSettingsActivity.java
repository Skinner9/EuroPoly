package com.example.europoly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class PlayerSettingsActivity extends AppCompatActivity {
    AppState appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_settings);
        Intent intent = getIntent();
        appState = (AppState)intent.getSerializableExtra("appState");
        CheckBox imAI = findViewById(R.id.isAI1);
        imAI.setEnabled(false);
    }
    public void apply(View view) {
        EditText name[] = {findViewById(R.id.name1), findViewById(R.id.name2),
                           findViewById(R.id.name3), findViewById(R.id.name4)};

        CheckBox isAI[] = {findViewById(R.id.isAI1), findViewById(R.id.isAI2),
                           findViewById(R.id.isAI3), findViewById(R.id.isAI4)};
        Spinner color[] = {findViewById(R.id.colors1), findViewById(R.id.colors2),
                           findViewById(R.id.colors3), findViewById(R.id.colors4)};
        for(int i=0; i<4; i++){
            if(!name[i].getText().toString().equals("")) {
                appState.players.add(new PlayerState(name[i].getText().toString(),
                        isAI[i].isChecked(), String.valueOf(color[i].getSelectedItem())));
            }
        }
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("appState", appState);
        startActivity(intent);
    }
    public void back(View view) {
        onBackPressed();
    }
}
