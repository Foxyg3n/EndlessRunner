package com.blackmc.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollingBackground extends Entity {

    Sprite sprite1, sprite2;

    float offset = 0;

    final float maxOffset;
    final float speed;

    public ScrollingBackground (Sprite sprite, float speed) {
        this.maxOffset = sprite.getWidth();
        this.speed = speed;

        sprite1 = new Sprite(sprite);
        sprite1.setSize(maxOffset, sprite1.getHeight());

        sprite2 = new Sprite(sprite);
        sprite2.setSize(maxOffset, sprite2.getHeight());
    }

    @Override
    public void create() {

    }

    @Override
    public void update(float deltaTime) {
        offset += speed * deltaTime;
        if(offset > maxOffset) offset = 0;

        sprite1.setPosition(-offset, sprite1.getY());
        sprite2.setPosition(-offset+maxOffset, sprite2.getY());
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite1.draw(batch);
        sprite2.draw(batch);
    }
}
