package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.game.HeroVillian;
import com.missionbit.game.sprites.Hero;

/**
 * Created by missionbit on 10/31/17.
 */

public class PlayState extends State {

    private Hero hero;
    private Texture bg;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, HeroVillian.WIDTH / 2, HeroVillian.HEIGHT / 2);
        hero = new Hero(50,100);
        bg = new Texture("background.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            hero.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        hero.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0, HeroVillian.WIDTH, HeroVillian.HEIGHT);
        sb.draw(hero.getTexture(), hero.getPosition().x, hero.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
