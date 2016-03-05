package net.tinku.donteatmebro.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import net.tinku.donteatmebro.Game;

public class AndroidLauncher extends AndroidApplication {

	NativeUIAndroid nativeUIAndroid;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useAccelerometer = false;
		config.useCompass = false;

		nativeUIAndroid = new NativeUIAndroid(this);
		initialize(new Game(nativeUIAndroid), config);
	}
}
