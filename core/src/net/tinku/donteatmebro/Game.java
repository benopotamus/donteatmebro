package net.tinku.donteatmebro;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class Game extends ApplicationAdapter {

	Stage stage;
	//UI uiStage;
	NativeUI nativeUI;
	Array<Animal> animals;

	public Game(NativeUI nativeUI) {
		// NativeUI is an interface to platform specific UI calls (e.g. display the wizard using native dialog, etc)
		this.nativeUI = nativeUI;
	}


	@Override
	public void dispose() {
		//uiStage.dispose();
	}


	@Override
	public void create () {

		//UI uiStage = new UI();

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		// Create world
		Planet planet = new Planet();
		stage.addActor(planet);

		// Create animals
		animals = new Array<Animal>();
		/*for (int i=0; i<100; i++) {
			spawnPig();
		}*/
		spawnPig();
		spawnPig();

		stage.addListener(new ActorGestureListener() {

			public void tap(InputEvent event, float x, float y, int count, int button) {
				nativeUI.showShortToast("hi");
				nativeUI.showUI();
			}

			public boolean longPress(Actor actor, float x, float y) {
				((OrthographicCamera) stage.getCamera()).zoom += 0.02f;
				stage.getCamera().update();
				return true;
			}

			public void pan(InputEvent event, float x, float y, float deltaX, float deltaY) {
				((OrthographicCamera) stage.getCamera()).translate(-deltaX, -deltaY);
				Gdx.app.log("DELTAS", "deltax=" + Float.toString(deltaX) + "   deltay=" + Float.toString(deltaY));
			}

			public void zoom(InputEvent event, float initialDistance, float distance) {
				float ratio = initialDistance / distance;
				((OrthographicCamera) stage.getCamera()).zoom *= ratio;
			}

			public void pinch(InputEvent event, Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
				//Gdx.app.log("PINCH", pointer1.toString() + "  " + pointer2.toString()); //(482.333,524.8029)  (233.69998,318.77957)
			}
		});

	}

	@Override
	/* This is called every frame */
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

		//uiStage.render();
	}

	public void resize (int width, int height) {
		//uiStage.resize(width, height);
	}


	private void spawnPig() {
		Animal pig = new Animal(new Texture(Gdx.files.internal("pig.png")));
		animals.add(pig);
		stage.addActor(pig);
	}

}
