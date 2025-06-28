package io.github.some_example_name.Object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import io.github.some_example_name.GameSettings;

public class PersonObject extends Sprite {
    private Texture texture;

    public PersonObject(World world) {
        texture = new Texture(Gdx.files.internal("player.png"));
    }

    public void draw(SpriteBatch batch) {
        if (texture != null) {
            batch.draw(texture, 0, 0, GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);
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

