package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.game.DiamondRush;

/**
 * Created by missionbit on 10/5/17.
 */

public class GameOverState extends State{

    private Texture bg;
    Music music;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("gameOver.png");
        cam.setToOrtho (false, DiamondRush.WIDTH,
                DiamondRush.HEIGHT);
        music = Gdx.audio.newMusic(Gdx.files.internal("gameover.mp3"));
        music.setLooping(true);
        music.setVolume(0.7f);
        music.play();
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0, 0, DiamondRush.WIDTH, DiamondRush.HEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {
        music.dispose();
        bg.dispose();
    }
}
