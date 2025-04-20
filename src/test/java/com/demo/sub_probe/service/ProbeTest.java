package com.demo.sub_probe.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProbeTest {
    @Test
    void testInitialState() {
        Grid grid = new Grid(5, 5);
        Position pos = new Position(1, 2);
        Direction dir = Direction.NORTH;
        Probe probe = new Probe(grid, pos, dir);

        assertEquals(pos, probe.getPosition());
        assertEquals(dir, probe.getDirection());
    }

    @Test
    void testMoveForward() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(grid, new Position(1, 2), Direction.NORTH);
        probe.move(Command.FORWARD);

        assertEquals(new Position(1, 3), probe.getPosition());
    }

    @Test
    void testMoveBackward() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(grid, new Position(1, 2), Direction.NORTH);
        probe.move(Command.BACKWARD);

        assertEquals(new Position(1, 1), probe.getPosition());
    }

    @Test
    void testTurnLeftAndRight() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(grid, new Position(0, 0), Direction.NORTH);

        probe.move(Command.LEFT);
        assertEquals(Direction.WEST, probe.getDirection());

        probe.move(Command.RIGHT);
        assertEquals(Direction.NORTH, probe.getDirection());
    }

    @Test
    void testBoundaryLimit() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(grid, new Position(0, 0), Direction.SOUTH);

        probe.move(Command.FORWARD); // would move out of bounds
        assertEquals(new Position(0, 0), probe.getPosition());
    }

    @Test
    void testObstacleAvoidance() {
        Grid grid = new Grid(5, 5);
        grid.addObstacle(new Position(1, 3));
        Probe probe = new Probe(grid, new Position(1, 2), Direction.NORTH);

        probe.move(Command.FORWARD);
        assertEquals(new Position(1, 2), probe.getPosition()); // should not move
    }

    @Test
    void testPathTracking() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(grid, new Position(1, 2), Direction.NORTH);

        probe.move(Command.FORWARD);
        probe.move(Command.RIGHT);
        probe.move(Command.FORWARD);

        List<Position> expectedPath = List.of(
                new Position(1, 2),
                new Position(1, 3),
                new Position(2, 3)
        );

        assertEquals(expectedPath, probe.getVisitedPath());
    }

}