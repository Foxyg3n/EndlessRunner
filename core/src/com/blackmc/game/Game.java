package com.blackmc.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Game extends ApplicationAdapter {
    DeltaClock clock;
    Scene scene;

    @Override
    public void create () {
        clock = new DeltaClock();
        scene = new Scene();

        scene.add(new Ground());
        scene.add(new Player());
    }

    @Override
    public void render () {
        // update
        float dt = clock.getDeltaTime();
        scene.update(dt);

        // render
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        scene.draw();
    }
    
    @Override
    public void dispose () {
        scene.dispose();
    }
}