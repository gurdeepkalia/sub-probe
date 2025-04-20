package com.demo.sub_probe.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
public class Probe {
    private final Grid grid;
    private Position position;
    private Direction direction;
    private final List<Position> visitedPath = new ArrayList<>();

    public Probe(Grid grid, Position startPosition, Direction startDirection) {
        this.grid = grid;
        this.position = startPosition;
        this.direction = startDirection;
        visitedPath.add(startPosition);
    }

    public void move(Command command) {
        //TODO : logic to move as per command goes here
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Position> getVisitedPath() {
        return new ArrayList<>(visitedPath);
    }
}
