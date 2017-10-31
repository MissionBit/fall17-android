package com.missionbit.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.game.DiamondRush;

/**
 * Created by missionbit on 10/31/17.
 */

public class PlayState extends State{

    private Texture pig = new Texture("pig2.png");

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, DiamondRush.WIDTH / 2, DiamondRush.HEIGHT / 2);

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(pig, -25, -40);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
