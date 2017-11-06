package com.missionbit.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.game.HeroVillian;

/**
 * Created by missionbit on 10/31/17.
 */

public class PlayState extends State {
    private Texture hero= new Texture("bird.png");
    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, HeroVillian.WIDTH / 2, HeroVillian.HEIGHT / 2);
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
        sb.draw(hero, 50, 50);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
