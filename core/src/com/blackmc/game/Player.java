package com.blackmc.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Player extends Entity {
    Sprite sprite;

    final float SPEED = 500;
    final float GRAVITY = 10;

    Vector2 pos, vel, acc;

    @Override
    public void create() {
        pos = new Vector2(150, 150);
        vel = new Vector2(0, 0);
        acc = new Vector2(0, 0);

        sprite = new Sprite(new Texture("blackmc.png"));

        sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
        sprite.setScale(0.5f);

        sprite.setPosition(pos.x, pos.y);
    }

    @Override
    public void update(float deltaTime) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP))
            acc.y += SPEED * deltaTime;

        // applying force
        vel.add(acc.x, acc.y);
        pos.add(vel);

        // gravity
        acc.add(0, -GRAVITY * deltaTime);
        acc.set(acc.x * 0.97f, acc.y * 0.3f);

        if(pos.y < 5) pos.y = 5;
     
        sprite.setPosition(pos.x, pos.y);

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            scene.remove(this);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch, 1);
    }
}
