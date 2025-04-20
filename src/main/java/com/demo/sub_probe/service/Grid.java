package com.demo.sub_probe.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
public class Grid {
    private final int length;
    private final int breadth;
    private final Set<Position> obstacles = new HashSet<>();

    public Grid(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public boolean isWithinBounds(Position position) {
        //logic to check if position is on grid or not
        return position.x() >= 0 && position.x() < length
                && position.y() >= 0 && position.y() < breadth;
    }

    public void addObstacle(Position position) {
        if (isWithinBounds(position)) {
            obstacles.add(position);
        }
    }

    public boolean hasObstacle(Position position) {
        return obstacles.contains(position);
    }
}
