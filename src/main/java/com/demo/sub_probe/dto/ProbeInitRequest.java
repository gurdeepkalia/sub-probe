package com.demo.sub_probe.dto;

import com.demo.sub_probe.service.Position;

import java.util.List;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
public class ProbeInitRequest {
    public int gridWidth;
    public int gridHeight;
    public int startX;
    public int startY;
    public String direction;
    public List<Position> obstacles;

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<Position> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Position> obstacles) {
        this.obstacles = obstacles;
    }
}
