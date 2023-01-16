package com.quid.redisGround.leaderBoard.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.quid.redisGround.leaderBoard.service.LeaderBoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeaderBoardControllerTest {

    @Autowired
    private LeaderBoardService leaderBoardService;

    @BeforeEach
    void setUp() {
        leaderBoardService.addRanking("user1", 100);
        leaderBoardService.addRanking("user2", 200);
        leaderBoardService.addRanking("user3", 300);
        leaderBoardService.addRanking("user4", 400);
        leaderBoardService.addRanking("user5", 500);
    }

    @Test
    void addRanking() {
        assertDoesNotThrow(() -> leaderBoardService.addRanking("test", 100));
    }

    @Test
    void getRanking() {
        assertEquals(4, leaderBoardService.getRanking("user4"));
    }

    @Test
    void getTopRanking() {
        assertEquals(3, leaderBoardService.getTopRanking(3).size());
    }

}