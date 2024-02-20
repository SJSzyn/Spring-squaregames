package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor heartbeatSensor;

    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/heartbeat")
    public int getHeartbeat() {
        return heartbeatSensor.get();
    }

    @GetMapping("/games/identifiers")
    public Collection<String> getGameIdentifiers() {
        return gameCatalog.getGameIdentifiers();
    }
}
