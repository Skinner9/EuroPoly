package com.example.europoly;

import java.io.Serializable;
import java.util.ArrayList;

enum GameMode {HotSeat, Multiplayer}
enum Language {English, Polish}
enum AIlevel {Easy, Medium, Hard}
enum ColorTheme {Blue, Red, Green}
enum Color {Blue, Red, Green, Yellow, Pink, Purple, Black}
class PlayerState implements Serializable {
    String name;
    Boolean AI;
    Color color;
    static Color toColor(String col) {
        if(col.equals("Blue"))return Color.Blue;
        if(col.equals("Red"))return Color.Red;
        if(col.equals("Green"))return Color.Green;
        if(col.equals("Yellow"))return Color.Yellow;
        if(col.equals("Pink"))return Color.Pink;
        if(col.equals("Purple"))return Color.Purple;
        if(col.equals("Black"))return Color.Black;
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
    Integer playersNumber, sound = 100, effects = 100;
    Boolean vibration = true;
    Language language = Language.English;
    AIlevel AI = AIlevel.Medium;
    ColorTheme colorTheme = ColorTheme.Blue;
    ArrayList<PlayerState> players = new ArrayList<>();
}
