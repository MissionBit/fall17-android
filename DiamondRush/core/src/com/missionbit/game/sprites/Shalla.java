package com.missionbit.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by missionbit on 11/2/17.
 */

public class Shalla {
    private Vector3 position;
    private Vector3 velocity;
    private Texture shalla;
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 200;
    private static final int GROUND = 35;
    private Rectangle bounds;

    public Shalla(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        shalla = new Texture("Shalla4.png");
        bounds = new Rectangle(position.x, position.y, shalla.getWidth(), shalla.getHeight());
    }

    public void update(float dt){
        if(position.y > GROUND){
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(dt);

        position.add(MOVEMENT * dt , velocity.y, 0);
        if(position.y < GROUND){
            position.y = GROUND ;
        }
        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return shalla;
    }

    public void jump(){
        if(position.y == GROUND){
            velocity.y = 800;
        }
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose(){
        shalla.dispose();
    }
}

