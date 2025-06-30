package io.github.some_example_name.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.GameResources;
import io.github.some_example_name.GameSettings;
import io.github.some_example_name.MainGame;
import io.github.some_example_name.Object.BugObject;
import io.github.some_example_name.Object.PersonObject;
import io.github.some_example_name.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
    private final MainGame mainGame;
    private Box2DDebugRenderer debugRenderer;
//    private OrthographicCamera camera;
    private PersonObject player;
    private Array<BugObject> bugs;

    public GameScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        debugRenderer = new Box2DDebugRenderer();
        player = new PersonObject(
            GameSettings.SCREEN_WIDTH / 4, 299,
            GameSettings.PL_WIDTH, GameSettings.PL_HEIGHT,
            Gdx.files.internal(GameResources.PLAYER_IMG_PATH),
            mainGame.world
        );
        bugs = new Array<>();
        spawnBugs();
    }

    private void draw() {
        mainGame.camera.update();
        mainGame.getBatch().setProjectionMatrix(mainGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        mainGame.getBatch().begin();
//        mainGame.draw(mainGame.getBatch());
        mainGame.getBatch().end();
    }

    private void spawnBugs() {
        for (int i = 0; i < 10; i++) {
            boolean isPoisonous = MathUtils.randomBoolean(0.2f);
//            bugs.add(new BugObject(mainGame.world, new Vector2(MathUtils.random(0, 800), MathUtils.random(0, 600)), isPoisonous));
        }
    }

    @Override
    public void show() {
        player.loadTextures();
        for (BugObject bug : bugs) {
            bug.loadTextures();
        }
    }

    @Override
    public void render(float delta) {
        mainGame.stepWorld();
        mainGame.camera.update();

        ScreenUtils.clear(Color.CLEAR);
        mainGame.world.step(1/60f, 6, 2);
        player.update();
        for (BugObject bug : bugs) {
            bug.update();
            if (player.getBounds().overlaps(player.getBounds())) {
                if (bug.isPoisonous()) {
                    mainGame.setScreen(new GameOverScreen(mainGame));
                } else {
                    bugs.removeValue(bug, true);
                }
            }
        }

        mainGame.getBatch().begin();
        player.draw(mainGame.getBatch());
//        for (BugObject bug : bugs) {
//            bug.draw(mainGame.getBatch());}
        mainGame.getBatch().end();

        if (Gdx.input.isTouched()) {
            mainGame.touch = mainGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

        }
        player.move(mainGame.touch);    }
}
