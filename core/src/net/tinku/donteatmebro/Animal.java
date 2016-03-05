package net.tinku.donteatmebro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by ben on 18/02/16.
 */
public class Animal extends Actor {

    float x,y;
    Texture texture;
    Integer movementCounter; // The number of steps before changing direction
    Integer xMovement;
    Integer yMovement;

    public Animal(Texture texture) {
        this.movementCounter = MathUtils.random(0, 20);
        this.texture = texture;
        this.x = MathUtils.random(0, 800);
        this.y = MathUtils.random(0, 800);

        this.xMovement = MathUtils.random(-1, 1);
        this.yMovement = MathUtils.random(-1, 1);


        setBounds(x,y,texture.getWidth(),texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,x,y);
    }

    @Override
    public void act(float delta){

        // If finished moving in current direction, choose a new one
        if (movementCounter == 0) {
            xMovement = MathUtils.random(-1, 1);
            yMovement = MathUtils.random(-1, 1);
            movementCounter = MathUtils.random(0, 20);
        }

        x += 2 * xMovement;
        y += 2 * yMovement;
        movementCounter--;

    }

    /*public boolean readyToMove() {
        if (this.movementCounter < 5) {
            this.movementCounter++;
            return false;
        }
        return true;
    }*/

    /*public void considerMoving() {
        if (this.movementCounter < 5) {
            this.movementCounter++;
        } else {
            this.y -= 10 * MathUtils.random(-1,1);
            this.x -= 10 * MathUtils.random(-1,1);
            this.movementCounter = 0;
        }
    }*/




}
