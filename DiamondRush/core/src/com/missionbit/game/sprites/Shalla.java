package com.missionbit.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by missionbit on 11/2/17.
 */

public class Shalla {
    private Vector3 position;
    private Vector3 velocity;
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 400;
    private static final int GROUND = 55;
    private Rectangle bounds;
    private Animation shallaAnimation;
    private Texture texture;
    private Sound jump;

    public Shalla(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("Shalla4.png");
        shallaAnimation = new Animation(new TextureRegion(texture), 2, 0.5f);
        bounds = new Rectangle(position.x, position.y, 15, 30);
        jump = Gdx.audio.newSound(Gdx.files.internal("jump.mp3"));
    }

    public void update(float dt){
        shallaAnimation.update(dt);
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

    public TextureRegion getTexture() {
        return shallaAnimation.getFrame();
    }

    public void jump(){
        if(position.y == GROUND){
            velocity.y = 300;
            jump.play(0.5f);
        }
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void dispose(){
       texture.dispose();
        jump.dispose();
    }
}

