package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;

import io.github.some_example_name.Screens.GameOverScreen;
import io.github.some_example_name.Screens.GameScreen;
import io.github.some_example_name.Screens.StartScreen;

public class MainGame extends Game {
    public World world;
    public Object largeWhiteFont;
    public Object commonBlackFont;
    public OrthographicCamera camera;
    private SpriteBatch batch;
    public GameScreen gameScreen;
    FitViewport viewport;

    public SpriteBatch getBatch() {
        return batch;
    }

    @Override
    public void create() {
        Box2D.init();
        world = new World(new Vector2(0, 0), true);

        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        viewport = new FitViewport(GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT, camera);


        camera.setToOrtho(false,GameSettings.SCREEN_WIDTH, GameSettings.SCREEN_HEIGHT);
        gameScreen = new GameScreen(this);
        setScreen(new StartScreen(this));

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height);

    }
}
