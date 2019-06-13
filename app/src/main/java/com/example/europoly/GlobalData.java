package com.example.europoly;

public class GlobalData {
    private static GlobalData instance = null;

    public AppState appState = new AppState();

    public static synchronized GlobalData getInstance() {
        if(null == instance){
            instance = new GlobalData();
        }
        return instance;
    }
}