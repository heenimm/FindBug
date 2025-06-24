package io.github.some_example_name;

import com.badlogic.gdx.utils.TimeUtils;

public class GameSession {
    public GameState state;
    long nextEnemySpawnTime;
    long sessionStartTime;
    long pauseStartTime;

    void startGame() {
        state = GameState.PLAYING;
        sessionStartTime = TimeUtils.millis();
        nextEnemySpawnTime = sessionStartTime + (long) (GameSettings.STARTING_ENEMY_APPEARANCE_COOL_DOWN * getEnemyPeriodCoolDown());

    }

    private int getEnemyPeriodCoolDown() {
        return 0;
    }

    void pauseGame() {
        state = GameState.PAUSED;
        pauseStartTime = TimeUtils.millis();

    }

    void resumeGame() {
        state = GameState.PLAYING;
        sessionStartTime += TimeUtils.millis() - pauseStartTime;

    }
}
