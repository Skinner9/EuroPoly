package com.example.europoly;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class SettingsActivity extends Activity {
    AppState appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appState = new AppState(GlobalData.getInstance().appState);
        setContentView(R.layout.activity_settings);
        Spinner ai_chooser = findViewById(R.id.AI_level);
        ai_chooser.setSelection(appState.AI.ordinal());
        Spinner language_chooser = findViewById(R.id.language);
        language_chooser.setSelection(appState.language.ordinal());
        Spinner theme_chooser = findViewById(R.id.color_theme);
        theme_chooser.setSelection(appState.colorTheme.ordinal());
        SeekBar sound = findViewById(R.id.soundLevel);
        sound.setMax(100);
        sound.setProgress(appState.sound);
        SeekBar effects = findViewById(R.id.effectsLevel);
        effects.setMax(100);
        effects.setProgress(appState.effects);
    }
    public void apply(View view) {
        Spinner ai_chooser = findViewById(R.id.AI_level);
        Spinner language_chooser = findViewById(R.id.language);
        Spinner theme_chooser = findViewById(R.id.color_theme);
        SeekBar sound = findViewById(R.id.soundLevel);
        SeekBar effects = findViewById(R.id.effectsLevel);
        CheckBox vibbration = findViewById(R.id.vibration);
        appState.AI = AppState.toAI(String.valueOf(ai_chooser.getSelectedItem()));
        appState.language = AppState.toLanguage(String.valueOf(language_chooser.getSelectedItem()));
        appState.colorTheme = AppState.toColorTheme(String.valueOf(theme_chooser.getSelectedItem()));
        appState.sound = sound.getProgress();
        appState.effects = effects.getProgress();
        appState.vibration = vibbration.isChecked();
        GlobalData.getInstance().appState = new AppState(appState);
        int langNum = language_chooser.getSelectedItemPosition();
        setLocale(AppState.toAcronym(Language.values()[langNum]));
        //onBackPressed();
    }
    public void back(View view) {
        onBackPressed();
    }

    public void setLocale(String lang) {
        Resources resources = getResources();
        Locale locale = new Locale("de");
        Configuration conf = resources.getConfiguration();
        conf.setLocale(locale);
        getApplicationContext().createConfigurationContext(conf);
        recreate();
        //Toast toast = Toast.makeText(getApplication().getBaseContext(),
        //        conf.locale.toString(), Toast.LENGTH_SHORT);
        //toast.show();
    }
}
