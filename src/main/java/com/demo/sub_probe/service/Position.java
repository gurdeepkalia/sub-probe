package com.demo.sub_probe.service;

public record Position(int x, int y) {
    /**
     * @param direction : direction in which to move
     * @param forward : forward movement or backward movement
     * @return : new position
    * */
    public Position move(Direction direction, boolean forward) {
        //TODO : logic for movement
        return new Position(0,0);
    }
}
