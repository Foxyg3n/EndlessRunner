package com.blackmc.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ground extends Entity {

    Sprite sprite1, sprite2;

    float offset = 0;

    final float SCREEN_WIDTH = 640;
    final float SCROLLING_SPEED = 80;

    @Override
    public void create() {
        Texture texture = new Texture("badlogic.jpg");

        sprite1 = new Sprite(texture);
        sprite1.setSize(SCREEN_WIDTH, 50);

        sprite2 = new Sprite(texture);
        sprite2.setSize(SCREEN_WIDTH, 50);
    }

    @Override
    public void update(float deltaTime) {
        offset += SCROLLING_SPEED * deltaTime;
        if(offset > SCREEN_WIDTH) offset = 0;

        sprite1.setPosition(-offset, 0);
        sprite2.setPosition(-offset+SCREEN_WIDTH, 0);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite1.draw(batch);
        sprite2.draw(batch);
    }
}
