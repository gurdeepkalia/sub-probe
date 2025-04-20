package com.demo.sub_probe.dto;

import com.demo.sub_probe.service.Command;

import java.util.List;

/**
 * @author Gurdeep Kalia (gurdeepk@lentra.ai)
 * CREATED ON : 20/04/25
 */
public class ProbeCommandRequest {
    public List<Command> commands;

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
