package com.missionbit.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by missionbit on 11/14/17.
 */

public class Log {
    private Texture log;
    private static final int FLUCTUATION = 500;
    private static final int LOG_MIN_X = 200;
    private Vector2 logPos;
    private Random rand;
    private Rectangle bounds;


    public Log(float x, float y){
        rand = new Random();
        log = new Texture("log.png");
        logPos = new Vector2(rand.nextInt(FLUCTUATION) + LOG_MIN_X, y);
        bounds = new Rectangle(logPos.x, logPos.y, 30, 30);
    }


    public Texture getLog() {
        return log;
    }

    public Vector2 getLogPos() {
        return logPos;
    }

    public void reposition(float x){
        logPos.set(x, 55);
        bounds.setPosition(logPos.x, logPos.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(bounds);
    }

    public void dispose(){
        log.dispose();
    }
}
