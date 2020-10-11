package com.blackmc.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
    Sprite sprite;

    final float SPEED = 200;
    final float GRAVITY = -20;
    final float AIR_RESISTANCE = 0.7f;
    final float GROUND_LEVEL = 100.0f;

    Vector2 position, velocity, acceleration;

    @Override
    public void create() {
        position = new Vector2(150, 150);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);

        sprite = new Sprite(new Texture("blackmc.png"));
        sprite.setSize(100, 100);
    }

    @Override
    public void update(float deltaTime) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP) ||
           Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            acceleration.y += SPEED * deltaTime;
        }

        // applying the acceleration
        velocity.add(acceleration.x, acceleration.y);
        position.add(velocity);

        if(position.y < GROUND_LEVEL) {
            position.y = GROUND_LEVEL;
            velocity.y = 0;
            acceleration.y = 0;
        }

        // applying gravity
        acceleration.add(0, GRAVITY * deltaTime);
        // applying air resistance
        acceleration.set(acceleration.x * (1.0f - AIR_RESISTANCE), 
                         acceleration.y * (1.0f - AIR_RESISTANCE));
        // adjusting sprite's position
        sprite.setPosition(position.x, position.y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
