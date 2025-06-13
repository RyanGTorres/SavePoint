package com.SavePoint.SavePoint.controller;

import com.SavePoint.SavePoint.controller.response.GameResponse;
import com.SavePoint.SavePoint.entity.Game;
import com.SavePoint.SavePoint.mapper.GameMapper;
import com.SavePoint.SavePoint.service.GameService;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/savepoint/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity <List<GameResponse>> findAll (){
        return ResponseEntity.ok(gameService.findAll().stream()
                .map(GameMapper::toGameResponse)
                .toList());
    }
}
