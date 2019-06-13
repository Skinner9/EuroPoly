package com.example.europoly;

import java.io.Serializable;
import java.util.ArrayList;

enum GameMode {HotSeat, Multiplayer}
enum Language {English, Polski}
enum AIlevel {Easy, Medium, Hard}
enum ColorTheme {Blue, Red, Green}
enum Color {Blue, Red, Green, Yellow, Pink, Purple, Black}
class PlayerState implements Serializable {
    String name;
    Boolean AI;
    Color color;
    static Color toColor(String col) {
        for(Color color : Color.values())
        if(col.equals(color.name()))return color;
        return null;
    }
    PlayerState(String nam, Boolean ai, Color col) {
        name=nam; AI=ai; color=col;
    }
    PlayerState(String nam, Boolean ai, String col) {
        name=nam; AI=ai; color=toColor(col);
    }
}
public class AppState implements Serializable {
    GameMode mode;
    Integer sound = 100, effects = 100;
    Boolean vibration = true;
    Language language = Language.English;
    AIlevel AI = AIlevel.Medium;
    ColorTheme colorTheme = ColorTheme.Blue;
    ArrayList<PlayerState> players = new ArrayList<>();
    AppState() {}
    AppState(AppState as) {
        sound = as.sound;
        effects = as.effects;
        vibration = as.vibration;
        language = as.language;
        AI = as.AI;
        colorTheme = as.colorTheme;
    }
    static AIlevel toAI(String ai) {
        for(AIlevel ail : AIlevel.values())
            if(ai.equals(ail.name()))return ail;
        return null;
    }
    static ColorTheme toColorTheme(String theme) {
        for(ColorTheme ct : ColorTheme.values())
            if(theme.equals(ct.name()))return ct;
        return null;
    }
    static Language toLanguage(String language) {
        for(Language l : Language.values())
            if(language.equals(l.name()))return l;
        return null;
    }
    static String toAcronym(Language language) {
        if(language==Language.English)return "en";
        if(language==Language.Polski)return "pl";
        return null;
    }
}
