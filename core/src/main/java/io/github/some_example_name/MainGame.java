package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.some_example_name.Screen.StartScreen;

public class MainGame extends Game {

    private SpriteBatch batch;

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new StartScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
