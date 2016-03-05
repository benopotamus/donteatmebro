package net.tinku.donteatmebro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by ben on 19/02/16.
 */
public class Planet extends Actor {

    Texture texture;

    public Planet() {
        texture = new Texture(Gdx.files.internal("world.png"));
        setBounds(0,0,texture.getWidth(),texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,0,0);
    }

    @Override
    public void act(float delta) {

    }
}
