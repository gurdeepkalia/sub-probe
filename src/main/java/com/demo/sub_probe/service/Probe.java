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
        //logic to move as per command goes here
        switch (command) {
            case FORWARD -> attemptMove(true);
            case BACKWARD -> attemptMove(false);
            case LEFT -> direction = direction.turnLeft();
            case RIGHT -> direction = direction.turnRight();
        }
    }

    private void attemptMove(boolean forward) {
        Position next = position.move(direction, forward);

        if (!grid.isWithinBounds(next)) {
            return; // stay in place if out of bounds
        }
        if (grid.hasObstacle(next)) {
            return; // stay in place if obstacle present
        }

        position = next;
        visitedPath.add(position);
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
