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
        //TODO : probe initialization logic goes here
    }

    public void processCommands(ProbeCommandRequest req) {
        //TODO : process command logic goes here
    }

    public ProbeStatusResponse getStatus() {
        //TODO : probe status fetch logic goes here
        return null;
    }
}
