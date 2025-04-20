package com.demo.sub_probe.controller;

import com.demo.sub_probe.dto.ProbeStatusResponse;
import com.demo.sub_probe.service.Direction;
import com.demo.sub_probe.service.Position;
import com.demo.sub_probe.service.ProbeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProbeController.class)
class ProbeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProbeService probeService;

    @Test
    void testInitProbe() throws Exception {
        String payload = """
            {
              "gridWidth": 5,
              "gridHeight": 5,
              "startX": 1,
              "startY": 2,
              "direction": "NORTH",
              "obstacles": [{"x":2,"y":2}]
            }
        """;

        mockMvc.perform(post("/probe/init")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk())
                .andExpect(content().string("Probe initialized"));

        verify(probeService, times(1)).initProbe(any());
    }

    @Test
    void testSendCommands() throws Exception {
        String payload = """
            {
              "commands": ["FORWARD", "RIGHT", "FORWARD"]
            }
        """;

        mockMvc.perform(post("/probe/command")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk());

        verify(probeService, times(1)).processCommands(any());
    }

    @Test
    void testGetStatus() throws Exception {
        ProbeStatusResponse mockResponse = new ProbeStatusResponse(
                new Position(2, 3),
                Direction.NORTH,
                List.of(new Position(1, 2), new Position(2, 2), new Position(2, 3))
        );

        when(probeService.getStatus()).thenReturn(mockResponse);

        mockMvc.perform(get("/probe/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.position.x").value(2))
                .andExpect(jsonPath("$.position.y").value(3))
                .andExpect(jsonPath("$.direction").value("NORTH"))
                .andExpect(jsonPath("$.path").isArray());
    }
}