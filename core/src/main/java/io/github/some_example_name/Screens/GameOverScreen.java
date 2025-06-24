package io.github.some_example_name.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.MainGame;
import io.github.some_example_name.ScreenAdapter;

public class GameOverScreen extends ScreenAdapter {
    private final MainGame game;
    private BitmapFont font;

    public GameOverScreen(MainGame game) {
        this.game = game;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Italic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            FreeTypeFontGenerator.DEFAULT_CHARS;
        parameter.size = 24;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.RED);
        game.getBatch().begin();
        font.draw(game.getBatch(), "Игра окончена! \nPress key.", 100, 150);
        game.getBatch().end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {

    }
}
