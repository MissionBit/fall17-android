package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.missionbit.game.DiamondRush;
import com.missionbit.game.sprites.Carrot;
import com.missionbit.game.sprites.Pig;

import java.util.Random;

/**
 * Created by missionbit on 10/31/17.
 */

public class PlayState extends State{
    private static final int BG_WIDTH = 1300;
    private static final int CARROT_WIDTH = 30;
    private static final int CARROT_SPACING = 20;
    private Pig pig;
    private Texture bg;
    private Carrot carrot;
    private Vector2 bgPos1, bgPos2, bgPos3;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, DiamondRush.WIDTH / 2, DiamondRush.HEIGHT / 2);
        bg = new Texture("CornField.png");
        carrot = new Carrot(100);
        pig = new Pig(50,50);
        bgPos1 = new Vector2(cam.position.x - cam.viewportWidth / 2 - BG_WIDTH, 0);
        bgPos2 = new Vector2(bg.getWidth() + bgPos1.x, 0);
        bgPos3 = new Vector2(bg.getWidth() + bgPos2.x, 0);
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
        cam.position.x = pig.getPosition().x + 80;

        updateCarrots();
        updateBg();
        cam.update();
    }

    public void updateCarrots() {
        if (carrot.getCarrotPos().x + CARROT_WIDTH <= cam.position.x - cam.viewportWidth / 2) {
            Random rand = new Random();
            float fluctuation = rand.nextFloat();
            float distance = (fluctuation * CARROT_SPACING) + DiamondRush.WIDTH;
            carrot.reposition(carrot.getCarrotPos().x + distance);
        }
    }

    public void updateBg() {
        if (bgPos1.x + 2 * bg.getWidth() <= cam.position.x - cam.viewportWidth / 2) {
            bgPos1.add(3 * bg.getWidth(), 0);
        }
        if (bgPos2.x + 2 * bg.getWidth() <= cam.position.x - cam.viewportWidth / 2) {
            bgPos2.add(3 * bg.getWidth(), 0);
        }
        if (bgPos3.x + 2*bg.getWidth() <= cam.position.x - cam.viewportWidth / 2) {
            bgPos3.add(3 * bg.getWidth(), 0);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, bgPos1.x, 0, BG_WIDTH, 300);
        sb.draw(bg, bgPos2.x, 0, BG_WIDTH, 300);
        sb.draw(bg, bgPos3.x, 0, BG_WIDTH, 300);
        sb.draw(pig.getTexture(), pig.getPosition().x, pig.getPosition().y);
        sb.draw(carrot.getCarrot(), carrot.getCarrotPos().x, carrot.getCarrotPos().y, 20,20);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
    }
}
