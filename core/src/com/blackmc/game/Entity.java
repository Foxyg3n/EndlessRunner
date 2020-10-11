package com.blackmc.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
    Scene scene;

    public Entity() {
        this.create();
    }

    public final void setScene(Scene scene) {
        this.scene = scene;
    }

    public abstract void create();
    public abstract void update(float deltaTime);
    public abstract void draw(SpriteBatch batch);
}
