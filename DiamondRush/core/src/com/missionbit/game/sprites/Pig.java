package com.missionbit.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by missionbit on 11/2/17.
 */

public class Pig {
    private Vector3 position;
    private Vector3 velocity;
    private Texture pig;
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    public Pig(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        pig = new Texture("pig.png");
    }

    public void update(float dt){
        if(position.y > GROUND){
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);

        position.add(MOVEMENT * dt , velocity.y, 0);
        if(position.y < 0){
            position.y = 0;
        }
        velocity.scl(1 / dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return pig;
    }

    public void jump(){
        if(position.y == GROUND){
            velocity.y = 350;
        }
    }
}

