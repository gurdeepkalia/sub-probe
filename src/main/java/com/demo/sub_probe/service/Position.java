package com.demo.sub_probe.service;

public record Position(int x, int y) {
    /**
     * @param direction : direction in which to move
     * @param forward : forward movement or backward movement
     * @return : new position
    * */
    public Position move(Direction direction, boolean forward) {
        int deltaX = direction.getDx();
        int deltaY = direction.getDy();

        if (!forward) {
            deltaX = (-1) * deltaX;
            deltaY = (-1) * deltaY;
        }

        return new Position(x + deltaX,y + deltaY);
    }
}
