package net.tinku.donteatmebro.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.tinku.donteatmebro.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Don't eat me bro";
		config.width = 800;
		config.height = 800;
		new LwjglApplication(new Game(), config);
	}
}
