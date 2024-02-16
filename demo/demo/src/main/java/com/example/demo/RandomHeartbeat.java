package com.example.demo;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    private final Random random = new Random();

    @Override
    public int get() {
        return 40 + random.nextInt(191);
    }
}