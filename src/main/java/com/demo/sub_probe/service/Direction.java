package com.demo.sub_probe.service;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
public enum Direction {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
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

    public Direction turn(boolean right) {
        return switch (this) {
            case NORTH -> right ? EAST : WEST;
            case EAST -> right ? SOUTH : NORTH;
            case SOUTH -> right ? WEST : EAST;
            case WEST -> right ? NORTH : SOUTH;
        };
    }
/*    public Direction turnLeft() {
        //logic for turning left
        int leftDirectionOrdinal = (this.ordinal() + 3) % 4;
        return Direction.values()[leftDirectionOrdinal];
    }

    public Direction turnRight() {
        //logic for turning right
        int rightDirectionOrdinal = (this.ordinal() + 1) % 4;
        return Direction.values()[rightDirectionOrdinal];
    }*/
}

