package com.demo.sub_probe.service;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
public enum Direction {
    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(1, 0),
    WEST(-1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public Direction turnLeft() {
        //TODO : logic for turning left
        return null;
    }

    public Direction turnRight() {
        //TODO : logic for turning right
        return null;
    }
}

