package com.blackmc.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Scene {
    ArrayList<Entity> entities;

    SpriteBatch batch;
    public Scene() {
        entities = new ArrayList<>();
        batch = new SpriteBatch();
    }

    public void draw() {
        batch.begin();

        for(Entity e : entities) {
            e.draw(batch);
        }
         
        batch.end();
    }

    public void update(float deltaTime) {
        ArrayList<Entity> list = new ArrayList<>(entities);
        for(Entity e : list) {
            e.update(deltaTime);
        }
    }

    public void dispose() {
        batch.dispose();
    }

    public void add(Entity e) {
        e.setScene(this);
        entities.add(e);
    }

    public void remove(Entity e) {
        entities.remove(e);
    }
}
