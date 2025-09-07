package com.example.demomusic.services.impl;

import com.example.demomusic.repository.TrainTimingDAO;
import com.example.demomusic.services.TrainService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrainServiceImplTest {

    @Mock
    private TrainTimingDAO trainTimingDAO;

    @InjectMocks
    private TrainServiceImpl trainService;

    @Test
    public void testCheckIn() {

        trainService.checkIn("123", "BLR", Instant.now());

    }

}
