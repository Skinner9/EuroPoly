package com.example.europoly;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    AppState appState;
    public static final Random RANDOM = new Random();
    private Button rollDices;
    private ImageView imageView3, imageView4;
    private int score1;
    private int score2;
    private int round = 0;
    private int currentRound = 0;
    private Player[] players;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        rollDices = (Button) findViewById(R.id.rollDices);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        players = new Player[]{new Player((ImageView) findViewById(R.id.imageView5)), new Player((ImageView) findViewById(R.id.imageView6)), new Player((ImageView) findViewById(R.id.imageView7)), new Player((ImageView) findViewById(R.id.imageView8))};


        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation anim1 = AnimationUtils.loadAnimation(GameActivity.this, R.anim.anim);
                final Animation anim2 = AnimationUtils.loadAnimation(GameActivity.this, R.anim.anim);
                final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        int x = randomReulst();
                        score1 = x;
                        String result = toStr(x);
                        int res = getResources().getIdentifier("dicesixfaces" + result, "drawable", "com.example.europoly");
                        if (animation == anim1)
                            imageView3.setImageResource(res);
                        else
                            imageView4.setImageResource(res);

                        score2 += score1;
                        round++;
                        if (round == 2) {
                            round = 0;
                            players[currentRound].move(score2);
                            currentRound++;
                            if (currentRound == 4)
                                currentRound = 0;
                            score2 = 0;
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };
                anim1.setAnimationListener(animationListener);
                anim2.setAnimationListener(animationListener);
                imageView3.startAnimation(anim1);
                imageView4.startAnimation(anim2);
            }

        });
    }


    public static int randomReulst() {
        return RANDOM.nextInt(6) + 1;
    }

    public static String toStr(int x) {
        if (x == 1)
            return "one";
        else if (x == 2)
            return "two";
        else if (x == 3)
            return "three";
        else if (x == 4)
            return "four";
        else if (x == 5)
            return "five";
        else
            return "six";
    }
}
