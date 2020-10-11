package com.blackmc.game;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Scene {
    ArrayList<Entity> entities;
    ArrayList<Entity> entities_to_add;

    SpriteBatch batch;

    public Scene() {
        entities = new ArrayList<>();
        entities_to_add = new ArrayList<>();
        batch = new SpriteBatch();
    }

    public void draw() {
        batch.begin();

        for(Entity e : entities)
            e.draw(batch);

        batch.end();
    }

    public void update(float deltaTime) {
        for(Entity e : entities)
            e.update(deltaTime);

        entities.addAll(entities_to_add);
        entities_to_add.clear();
    }

    public void dispose() {
        batch.dispose();
    }

    public void add(Entity e) {
        e.setScene(this);
        entities_to_add.add(e);
    }
}
