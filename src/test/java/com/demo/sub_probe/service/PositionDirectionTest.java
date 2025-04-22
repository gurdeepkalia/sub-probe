package com.demo.sub_probe.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionDirectionTest {

    @Test
    void testMoveForwardNorth() {
        Position p = new Position(1,2);
        Position moved = p.move(Direction.NORTH, true);
        assertEquals(new Position(1,3), moved);
    }

    @Test
    void testMoveBackwardEast() {
        Position p = new Position(2, 2);
        Position moved = p.move(Direction.EAST, false);
        assertEquals(new Position(1, 2), moved);
    }

    @Test
    void testTurnLeftFromNorth() {
        assertEquals(Direction.WEST, Direction.NORTH.turn(false));
    }

    @Test
    void testTurnRightFromNorth() {
        assertEquals(Direction.EAST, Direction.NORTH.turn(true));
    }

}