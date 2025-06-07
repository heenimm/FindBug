package io.github.some_example_name.Object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class PersonObject extends Sprite {

        private Body body;

        public PersonObject(World world) {
        }

        public void update() {
        }

        public Rectangle getBounds() {
            return getBoundingRectangle();
        }
}
