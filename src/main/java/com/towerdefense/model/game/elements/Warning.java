package com.towerdefense.model.game.elements;

public class Warning extends Element {
    private String[] messages; // Array of messages for multiple lines
    private long duration; // Duration in milliseconds
    private long startTime;
    private String color;

    public Warning(int x, int y, String[] messages, long duration, String color) {
        super(x, y);
        this.messages = messages;
        this.duration = duration;
        this.startTime = System.currentTimeMillis();
        this.color = color;
    }

    public String[] getMessages() {
        return messages;
    }

    public boolean isActive() {
        return System.currentTimeMillis() - startTime < duration;
    }

    public void reset(String[] newMessages, long newDuration) {
        this.messages = newMessages;
        this.duration = newDuration;
        this.startTime = System.currentTimeMillis();
    }

    public String getColor() {
        return color;
    }
}