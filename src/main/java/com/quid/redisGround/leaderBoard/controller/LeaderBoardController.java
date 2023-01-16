package com.quid.redisGround.leaderBoard.controller;

import com.quid.redisGround.leaderBoard.dto.UserScoreDto;
import com.quid.redisGround.leaderBoard.service.LeaderBoardService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaderBoard")
@RequiredArgsConstructor
public class LeaderBoardController {

    private final LeaderBoardService leaderBoardService;

    @PostMapping
    public void addRanking(@RequestBody UserScoreDto userScoreDto) {
        leaderBoardService.addRanking(userScoreDto.name(), userScoreDto.score());
    }

    @GetMapping("/{name}")
    public Long getRanking(@PathVariable String name) {
        return leaderBoardService.getRanking(name);
    }

    @PostMapping("/top/{limit}")
    public List getTopRanking(@PathVariable int limit) {
        return new ArrayList(leaderBoardService.getTopRanking(limit));
    }



}
