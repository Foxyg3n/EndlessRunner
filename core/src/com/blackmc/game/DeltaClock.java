package com.blackmc.game;

public class DeltaClock {
    private float lastTime;

    public DeltaClock() {
        lastTime = System.nanoTime();
    }

    public float getDeltaTime () {
        float currentTime = System.nanoTime();
        float deltaTime = currentTime - lastTime;
        lastTime = currentTime;

        // converting nanoseconds to seconds
        return deltaTime / 1000000000;
    }
}

