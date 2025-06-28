package io.github.some_example_name.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.some_example_name.GameSettings;
import io.github.some_example_name.MainGame;
import io.github.some_example_name.ScreenAdapter;

public class StartScreen extends ScreenAdapter {
    private final MainGame mainGame;
    private BitmapFont font;

    public StartScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Italic.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        int baseSize = 30;
        parameter.size = (int)(baseSize * Gdx.graphics.getDensity());

        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            FreeTypeFontGenerator.DEFAULT_CHARS;

        font = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        mainGame.getBatch().begin();

        float textWidth = new GlyphLayout(font, "ДА НАЧНЕТСЯ ИГРА").width;
        font.draw(mainGame.getBatch(), "ДА НАЧНЕТСЯ ИГРА", (Gdx.graphics.getWidth() - textWidth)/2, Gdx.graphics.getHeight() / 2);
        font.draw(mainGame.getBatch(), "Press any key!",  50, 50);

        mainGame.getBatch().end();

        if (Gdx.input.justTouched()) {
            mainGame.setScreen(new GameScreen(mainGame));
        }
    }
}
