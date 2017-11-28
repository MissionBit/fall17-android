package com.missionbit.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.game.DiamondRush;

/**
 * Created by missionbit on 10/5/17.
 */

public class MenuState extends State{

    private Texture menu;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        menu = new Texture("farm.png");
        playBtn = new Texture ("playbtn.png");
        cam.setToOrtho (false, DiamondRush.WIDTH / 2,
                DiamondRush.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(menu, 0, 0, DiamondRush.WIDTH, DiamondRush.HEIGHT);
        sb.draw(playBtn, 500,300);
        sb.end();
    }

    @Override
    public void dispose() {
        menu.dispose();
        playBtn.dispose();
    }
}
