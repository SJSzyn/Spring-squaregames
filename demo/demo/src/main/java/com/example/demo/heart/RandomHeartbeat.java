package com.example.demo.heart;

import java.util.Random;

import com.example.demo.heart.HeartbeatSensor;
import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    private final Random random = new Random();

    @Override
    public int get() {
        return 40 + random.nextInt(191);
    }
}