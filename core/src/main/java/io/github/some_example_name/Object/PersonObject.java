package io.github.some_example_name.Object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.physics.box2d.World;

import io.github.some_example_name.GameSettings;

public class PersonObject extends GameObject {

    public PersonObject (int x, int y, int width, int height, FileHandle texturePath, World world) {
        super(String.valueOf(texturePath), x, y, width, height, world);
        body.setLinearDamping(10);
    }

    public void draw(SpriteBatch batch) {
        if (texture != null) {
            batch.draw(texture, 0, 0, GameSettings.SCREEN_WIDTH / 3, GameSettings.SCREEN_HEIGHT / 3);
        } else {
            Gdx.app.error("PersonObject", "Texture is null!");
        }
    }

    public void dispose() {
        if (texture != null) texture.dispose();
    }

    public Circle getBounds() {
        return new Circle();
    }

    public void update() {
    }

    public void loadTextures() {
    }
}

