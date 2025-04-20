package com.demo.sub_probe.controller;

import com.demo.sub_probe.dto.ProbeCommandRequest;
import com.demo.sub_probe.dto.ProbeInitRequest;
import com.demo.sub_probe.dto.ProbeStatusResponse;
import com.demo.sub_probe.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
@RestController
@RequestMapping("/probe")
public class ProbeController {
    private final ProbeService service;

    @Autowired
    public ProbeController(ProbeService service) {
        this.service = service;
    }

    @PostMapping("/init")
    public ResponseEntity<String> init(@RequestBody ProbeInitRequest req) {
        service.initProbe(req);
        return ResponseEntity.ok("Probe initialized");
    }

    @PostMapping("/command")
    public ResponseEntity<String> command(@RequestBody ProbeCommandRequest req) {
        service.processCommands(req);
        return ResponseEntity.ok("Commands executed");
    }

    @GetMapping("/status")
    public ResponseEntity<ProbeStatusResponse> status() {
        return ResponseEntity.ok(service.getStatus());
    }
}
