package com.blackmc.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Game extends ApplicationAdapter {
    DeltaClock clock;
    Scene scene;

    @Override
    public void create () {
        clock = new DeltaClock();
        scene = new Scene();

        Sprite ground_back = new Sprite(new Texture("mountains.png"));
        ground_back.setSize(640, 200);
        scene.add(new ScrollingBackground(ground_back, 50));

        Sprite ground_front = new Sprite(new Texture("ground.png"));
        ground_front.setSize(640, 110);
        scene.add(new ScrollingBackground(ground_front, 100));

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