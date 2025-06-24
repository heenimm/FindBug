package io.github.some_example_name.Screens;

import io.github.some_example_name.GameResources;
import io.github.some_example_name.Main;
import io.github.some_example_name.ScreenAdapter;
import io.github.some_example_name.Views.ButtonView;
import io.github.some_example_name.Views.MovingBackgroundView;
import io.github.some_example_name.Views.TextView;

public class MenuScreen extends ScreenAdapter {
    Main myGdxGame;
    TextView titleView;
    ButtonView startButtonView;
    ButtonView settingsButtonView;
    ButtonView exitButtonView;
    MovingBackgroundView backgroundView;


    public MenuScreen(Main myGdxGame) {
        this.myGdxGame = myGdxGame;
        backgroundView = new MovingBackgroundView(GameResources.BACKGROUND_IMG_PATH);

        titleView = new TextView(myGdxGame.largeWhiteFont, 180, 960, "Space Cleaner");

        startButtonView = new ButtonView(140, 646, 440, 70, myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH, "start");
        settingsButtonView = new ButtonView(140, 551, 440, 70, myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH, "settings");
        exitButtonView = new ButtonView(140, 456, 440, 70, myGdxGame.commonBlackFont, GameResources.BUTTON_LONG_BG_IMG_PATH, "exit");


    }
}
