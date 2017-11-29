package com.missionbit.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by missionbit on 11/14/17.
 */

public class Log {
    private Texture carrot;
    private static final int FLUCTUATION = 500;
    private static final int CARROT_MIN_X = 200;
    private Vector2 carrotPos;
    private Random rand;
    private Rectangle bounds;


    public Log(float x, float y){
        rand = new Random();
        carrot = new Texture("log.png");
        carrotPos = new Vector2(rand.nextInt(FLUCTUATION) + CARROT_MIN_X, y);
        bounds = new Rectangle(carrotPos.x, carrotPos.y, carrot.getWidth(), carrot.getHeight());
    }


    public Texture getCarrot() {
        return carrot;
    }

    public Vector2 getCarrotPos() {
        return carrotPos;
    }

    public void reposition(float x){
        carrotPos.set(x, 35);
        bounds.setPosition(carrotPos.x, carrotPos.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(bounds);
    }

    public void dispose(){
        carrot.dispose();
    }
}
