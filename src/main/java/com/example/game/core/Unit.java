
package com.example.game.core;

public abstract class Unit implements Movable {
    protected final String name;
    protected final int id;
    protected Point2D position;
    protected final boolean flying;

    public Unit(String name, int id, boolean flying, Point2D startPos) {
        this.name = name;
        this.id = id;
        this.flying = flying;
        this.position = startPos;
    }

    public String getDisplayName() {
        return name + "-" + id;
    }

    public boolean isFlying() {
        return flying;
    }

    public Point2D getPosition() {
        return position;
    }

    protected void log(String message) {
        System.out.println("[" + getDisplayName() + "] " + message);
    }

    @Override
    public abstract void moveTo(Point2D dest);
}
