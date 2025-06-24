package io.github.some_example_name.Screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.MainGame;
import io.github.some_example_name.Object.BugObject;
import io.github.some_example_name.Object.PersonObject;
import io.github.some_example_name.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
    private final MainGame game;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    private PersonObject player;
    private Array<BugObject> bugs;

    public GameScreen(MainGame game) {
        this.game = game;
        world = new World(new Vector2(0, 0), true);
        debugRenderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(800, 600);
        player = new PersonObject(world);
        bugs = new Array<>();
        spawnBugs();
    }

    private void spawnBugs() {
        for (int i = 0; i < 10; i++) {
            boolean isPoisonous = MathUtils.randomBoolean(0.2f);
            bugs.add(new BugObject(world, new Vector2(MathUtils.random(0, 800), MathUtils.random(0, 600)), isPoisonous));
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.DARK_GRAY);
        world.step(1/60f, 6, 2);
        player.update();
        for (BugObject bug : bugs) {
            bug.update();
            if (player.getBounds().overlaps(bug.getBounds())) {
                if (bug.isPoisonous()) {
                    game.setScreen(new GameOverScreen(game));
                } else {
                    bugs.removeValue(bug, true);
                }
            }
        }

        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        player.draw(game.getBatch());
        for (BugObject bug : bugs) {
            bug.draw(game.getBatch());
        }
        game.getBatch().end();

        debugRenderer.render(world, camera.combined);
    }
}
