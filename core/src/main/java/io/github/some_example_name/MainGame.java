package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.some_example_name.Screens.GameOverScreen;

public class MainGame extends Game {

    public Object largeWhiteFont;
    public Object commonBlackFont;
    private SpriteBatch batch;

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new GameOverScreen(this));

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
