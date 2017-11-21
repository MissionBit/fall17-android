package com.missionbit.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.missionbit.game.HeroVillian;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = HeroVillian.WIDTH;
		config.height = HeroVillian.HEIGHT;
		config.title = HeroVillian.TITLE;
		new LwjglApplication(new HeroVillian(), config);
	}
}
