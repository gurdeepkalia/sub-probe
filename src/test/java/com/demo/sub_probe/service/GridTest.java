package com.demo.sub_probe.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    void testPositionWithinBounds() {
        Grid grid = new Grid(5, 5);
        assertTrue(grid.isWithinBounds(new Position(4, 4)));
        assertFalse(grid.isWithinBounds(new Position(5, 5)));
        assertFalse(grid.isWithinBounds(new Position(-1, 2)));
    }

    @Test
    void testAddAndCheckObstacle() {
        Grid grid = new Grid(5, 5);
        Position obstacle = new Position(2, 2);
        grid.addObstacle(obstacle);

        assertTrue(grid.hasObstacle(obstacle));
        assertFalse(grid.hasObstacle(new Position(1, 1)));
    }
}