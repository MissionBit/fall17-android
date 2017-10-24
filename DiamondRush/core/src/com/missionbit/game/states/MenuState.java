package com.missionbit.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.game.DiamondRush;

/**
 * Created by missionbit on 10/5/17.
 */

public class MenuState extends State{

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        //I MADE THIS
//        background = new Texture("bg.png");
//        playBtn = new Texture ("platBtn.png");
//        cam.setToOrtho (false, FlappyDemo.WIDTH / 2,
//                FlappyDemo.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void dispose() {

    }
}
