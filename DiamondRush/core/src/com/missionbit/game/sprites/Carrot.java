package com.missionbit.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by missionbit on 11/14/17.
 */

public class Carrot {
    private Texture carrot;
    private static final int FLUCTUATION = 500;
    private static final int CARROT_MIN_X = 200;
    private Vector2 carrotPos;
    private Random rand;


    public Carrot(float x){
        rand = new Random();
        carrot = new Texture("carrot.png");

        carrotPos = new Vector2(rand.nextInt(FLUCTUATION) + CARROT_MIN_X, 0);
    }


    public Texture getCarrot() {
        return carrot;
    }

    public Vector2 getCarrotPos() {
        return carrotPos;
    }

    public void reposition(float x){
        carrotPos.set(x, 0);

    }
}
