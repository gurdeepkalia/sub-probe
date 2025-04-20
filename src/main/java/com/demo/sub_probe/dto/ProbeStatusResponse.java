package com.demo.sub_probe.dto;

import com.demo.sub_probe.service.Direction;
import com.demo.sub_probe.service.Position;

import java.util.List;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
public class ProbeStatusResponse {
    public Position position;
    public Direction direction;
    public List<Position> path;

    public ProbeStatusResponse(Position position, Direction direction, List<Position> path) {
        this.position = position;
        this.direction = direction;
        this.path = path;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Position> getPath() {
        return path;
    }

    public void setPath(List<Position> path) {
        this.path = path;
    }
}
