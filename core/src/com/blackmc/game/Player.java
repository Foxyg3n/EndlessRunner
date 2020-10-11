package com.blackmc.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Player extends Entity {
    Sprite sprite;

    final float SPEED = 240;
    float posX;
    float posY;

    final float ROTATION_SPEED = 50;
    float rotation = 0;

    @Override
    public void create() {
        sprite = new Sprite(new Texture("badlogic.jpg"));

        sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
        sprite.setScale(0.5f);

        Random rnd = new Random();
        posX = rnd.nextInt(400);
        posY = rnd.nextInt(400);
        sprite.setPosition(posX, posY);
    }

    @Override
    public void update(float deltaTime){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            posX += SPEED * deltaTime;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            posX -= SPEED * deltaTime;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            posY -= SPEED * deltaTime;
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            posY += SPEED * deltaTime;

        sprite.setPosition(posX, posY);

        sprite.setRotation(rotation+=ROTATION_SPEED*deltaTime);

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            scene.remove(this);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch, 1);
    }
}
