package io.github.some_example_name.Object;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class BugObject extends Sprite {
    private Body body;
    private boolean poisonous;

    public BugObject(World world, Vector2 position, boolean poisonous) {
//        super(texture);
        this.poisonous = poisonous;

        setSize(16 / 100f, 16 / 100f);
        setPosition(position.x, position.y);

        BodyDef bdef = new BodyDef();
        bdef.position.set(position);
        bdef.type = BodyType.StaticBody;
        body = world.createBody(bdef);

        CircleShape shape = new CircleShape();
        shape.setRadius(getWidth() / 2f);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        fdef.isSensor = true;
        body.createFixture(fdef).setUserData(this);
        shape.dispose();
    }

    public void update() {
        setPosition(body.getPosition().x - getWidth() / 2, body.getPosition().y - getHeight() / 2);
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public Rectangle getBounds() {
        return getBoundingRectangle();
    }

    public Body getBody() {
        return body;
    }
}
