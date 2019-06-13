package com.example.europoly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashSet;

public class PlayerSettingsActivity extends Activity {
    AppState appState;
    boolean isPlayerHasName(String name) {
        if(name.equals("")) {
            Toast toast = Toast.makeText(getApplication().getBaseContext(),
                    "Choose your name!", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        return true;
    }
    boolean areVariousPlayerColors(Spinner color[], EditText name[]) {
        int activePlayers = 0;
        HashSet<String> playerColors = new HashSet<>();
        for (int i = 0; i < 4; i++)
            if (!name[i].getText().toString().equals("")) {
                playerColors.add(String.valueOf(color[i].getSelectedItem()));
                activePlayers++;
                if (playerColors.size() < activePlayers) {
                    Toast toast = Toast.makeText(getApplication().getBaseContext(),
                            "Choose various colors!", Toast.LENGTH_SHORT);
                    toast.show();
                    return false;
                }
            }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_settings);
        appState = GlobalData.getInstance().appState;
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

        if(!isPlayerHasName(name[0].getText().toString())) return;
        if(!areVariousPlayerColors(color, name)) return;

        for(int i=0; i<4; i++) {
            if(!name[i].getText().toString().equals("")) {
                appState.players.add(new PlayerState(name[i].getText().toString(),
                        isAI[i].isChecked(), String.valueOf(color[i].getSelectedItem())));
            }
        }
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    public void back(View view) {
        onBackPressed();
    }
}
