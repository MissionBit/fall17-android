package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.missionbit.game.DiamondRush;
import com.missionbit.game.sprites.Log;
import com.missionbit.game.sprites.Shalla;

import java.util.Random;

/**
 * Created by missionbit on 10/31/17.
 */

public class PlayState extends State{
    private static final int BG_WIDTH = 1300;
    private static final int CARROT_WIDTH = 30;
    private static final int CARROT_SPACING = 20;
    private Shalla shalla;
    private Texture bg;
    private Log log;
    private Vector2 bgPos1, bgPos2, bgPos3;
    public Music music;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, DiamondRush.WIDTH / 2, DiamondRush.HEIGHT / 2);
        bg = new Texture("background.png");
        log = new Log(100, 55);
        shalla = new Shalla(50,100);
        bgPos1 = new Vector2(cam.position.x - cam.viewportWidth / 2 - BG_WIDTH, 0);
        bgPos2 = new Vector2(bg.getWidth() + bgPos1.x, 0);
        bgPos3 = new Vector2(bg.getWidth() + bgPos2.x, 0);
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.5f);
        music.play();
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            shalla.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        updateBg();
        shalla.update(dt);
        cam.position.x = shalla.getPosition().x + 80;
        updateCarrots();
        if(log.collides(shalla.getBounds())) {
            gsm.set(new GameOverState(gsm));
        }
        cam.update();
    }

    public void updateCarrots() {
        if (log.getLogPos().x + CARROT_WIDTH <= cam.position.x - cam.viewportWidth / 2) {
            Random rand = new Random();
            float fluctuation = rand.nextFloat();
            float distance = ( fluctuation * CARROT_SPACING) + DiamondRush.WIDTH;
            log.reposition(log.getLogPos().x + distance);
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
        sb.draw(shalla.getTexture(), shalla.getPosition().x, shalla.getPosition().y);
        sb.draw(log.getLog(), log.getLogPos().x, log.getLogPos().y, 60,60);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        shalla.dispose();
        log.dispose();
        music.dispose();
    }

}
