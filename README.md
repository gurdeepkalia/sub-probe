# Submersible Probe Control API

This is a simple REST API to remotely control a submersible probe on a 2D ocean floor grid.  
It supports movement, turning, obstacle avoidance, and tracking visited coordinates.

---

## Features

- Initialize probe with grid size, position, direction, and obstacles
- Send movement and turn commands
- Prevents moving outside the grid or into obstacles
- Tracks all coordinates visited
- Exposes current status via API

---

## Requirements
- Java 17+ 
- Spring Boot 3.4+

---

## Endpoints

### `POST /probe/init`
Initialize the probe.

```json
{
  "gridWidth": 5,
  "gridHeight": 5,
  "startX": 1,
  "startY": 2,
  "direction": "NORTH",
  "obstacles": [{"x":2, "y":2}]
}
```

### `POST /probe/command`
Send movement and turn commands to the probe.
Available commands: "FORWARD", "BACKWARD", "LEFT", "RIGHT"

```json
{
  "commands": ["FORWARD", "RIGHT", "FORWARD"]
}
```

### `GET /probe/status`
Get the current status of the probe.
```json
{
  "position": { "x": 2, "y": 3 },
  "direction": "EAST",
  "path": [
    { "x": 1, "y": 2 },
    { "x": 1, "y": 3 },
    { "x": 2, "y": 3 }
  ]
}
```

---

## Run Tests
`mvn test`

---

## Run the Application
`mvn spring-boot:run`