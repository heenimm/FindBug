package io.github.some_example_name.Object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;


public class BugObject extends Sprite {
    private Body body;
    private boolean poisonous;

    public BugObject(World world, Vector2 position, boolean poisonous) {
        this.poisonous = poisonous;
    }

    public void update() {
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public Rectangle getBounds() {
        return getBoundingRectangle();
    }
}
