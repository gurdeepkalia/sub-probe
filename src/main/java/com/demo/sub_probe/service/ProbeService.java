package com.demo.sub_probe.service;

import com.demo.sub_probe.dto.ProbeCommandRequest;
import com.demo.sub_probe.dto.ProbeInitRequest;
import com.demo.sub_probe.dto.ProbeStatusResponse;
import org.springframework.stereotype.Service;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
@Service
public class ProbeService {
    private Probe probe;

    public void initProbe(ProbeInitRequest req) {
        //probe initialization logic goes here
        Grid grid = new Grid(req.gridWidth, req.gridHeight);
        if (req.obstacles != null) {
            req.obstacles.forEach(grid::addObstacle);
        }
        Position start = new Position(req.startX, req.startY);
        Direction dir = Direction.valueOf(req.direction);
        this.probe = new Probe(grid, start, dir);
    }

    public void processCommands(ProbeCommandRequest req) {
        //process command logic goes here
        if (probe == null) throw new IllegalStateException("Probe not initialized");
        for (Command cmd : req.commands) {
            probe.move(cmd);
        }
    }

    public ProbeStatusResponse getStatus() {
        //probe status fetch logic goes here
        if (probe == null) throw new IllegalStateException("Probe not initialized");
        return new ProbeStatusResponse(
                probe.getPosition(),
                probe.getDirection(),
                probe.getVisitedPath()
        );
    }
}
