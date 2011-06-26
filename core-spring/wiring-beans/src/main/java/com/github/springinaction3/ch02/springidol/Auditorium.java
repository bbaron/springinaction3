package com.github.springinaction3.ch02.springidol;

public class Auditorium {

    private boolean on = false;
    public void turnOnLights() {
        on = true;
    }

    public void turnOffLights() {
        on = false;
    }

    public boolean areOn() {
        return on;
    }
}
