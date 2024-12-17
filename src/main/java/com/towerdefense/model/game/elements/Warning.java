package com.towerdefense.model.game.elements;

public class Warning extends Element {
    private String message;
    private long duration; // Duration in milliseconds
    private long startTime;

    public Warning(int x, int y, String message, long duration) {
        super(x, y);
        this.message = message;
        this.duration = duration;
        this.startTime = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }

    public boolean isActive() {
        return System.currentTimeMillis() - startTime < duration;
    }

    public void reset(String newMessage, long newDuration) {
        this.message = newMessage;
        this.duration = newDuration;
        this.startTime = System.currentTimeMillis();
    }
}
