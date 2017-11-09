package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.missionbit.game.DiamondRush;
import com.missionbit.game.sprites.Pig;

/**
 * Created by missionbit on 10/31/17.
 */

public class PlayState extends State{

    private Pig pig;
    private Texture bg;
    private Texture carrot;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, DiamondRush.WIDTH / 2, DiamondRush.HEIGHT / 2);
        bg = new Texture("newmenu1.png");
        carrot = new Texture("carrot.png");
        pig = new Pig(50,50);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            pig.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        pig.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0, 0);
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(pig.getTexture(), pig.getPosition().x, pig.getPosition().y);
        sb.draw(carrot, 50, 0, 25, 25);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        carrot.dispose();
    }
}
