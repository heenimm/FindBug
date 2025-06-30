package io.github.some_example_name.Object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;

import io.github.some_example_name.GameSettings;

public class PersonObject extends GameObject {

    public PersonObject (int x, int y, int width, int height, FileHandle texturePath, World world) {
        super(String.valueOf(texturePath), x, y, width, height, world);
        body.setLinearDamping(10);
    }


    private void putInFrame() {
        if (getY() > (GameSettings.SCREEN_HEIGHT / 2f - GameSettings.PL_HEIGHT / 2f)) {
            setY(GameSettings.SCREEN_HEIGHT / 2 - GameSettings.PL_HEIGHT / 2);
        }
        if (getY() <= (GameSettings.PL_HEIGHT / 2f)) {
            setY(GameSettings.PL_HEIGHT / 2);
        }
        if (getX() < (-GameSettings.PL_WIDTH / 2f)) {
            setX(GameSettings.SCREEN_WIDTH);
        }
        if (getX() > (GameSettings.SCREEN_WIDTH + GameSettings.PL_WIDTH  / 2f)) {
            setX(0);
        }
    }

    public void move(Vector3 vector3) {
        body.applyForceToCenter(new Vector2(
                (vector3.x - getX()) * GameSettings.SHIP_FORCE_RATIO,
                (vector3.y - getY()) * GameSettings.SHIP_FORCE_RATIO),
            true
        );
    }

    public Circle getBounds() {
        return new Circle();
    }

    public void update() {
    }

    public void loadTextures() {
    }
}

