package com.example.europoly;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Player {
    private ImageView token;
    private float moveLength, asX, asY;
    private int position;
    private boolean isJail;


    public Player(ImageView token) {
        this.token = token;
        position = 0;
        moveLength = 2.5f;
    }

    public void move(int range)  {
        for (int i = 0; i < range; ++i) {
            asX = token.getX();
            asY = token.getY();
            if (position == 40) position = 0;
            if (position % 10 == 0 || position % 9 == 0) moveLength = 3.5f;
            else moveLength = 2.5f;

            if (position < 10) {
               // token.animate().x(asX - (2.5f * token.getWidth())).y(asY).setDuration(200);
                token.setX(asX - (moveLength * token.getWidth()));
                token.setY(asY);
            } else if (position < 20) {
                // imageView5.animate().x(asX).y(asY - (2.5f * imageView5.getWidth())).setDuration(200);
                token.setX(asX);
                token.setY(asY - (moveLength * token.getWidth()));
            } else if (position < 30) {
                //imageView5.animate().x(asX + (2.5f * imageView5.getWidth())).y(asY).setDuration(200);
                token.setX(asX + (moveLength * token.getWidth()));
                token.setY(asY);
            } else if (position < 40) {
                // imageView5.animate().x(asX).y(asY + (2.5f * imageView5.getWidth())).setDuration(200);
                token.setX(asX);
                token.setY(asY + (moveLength * token.getWidth()));
            }
            position++;
            token.invalidate();
        }
    }
}
