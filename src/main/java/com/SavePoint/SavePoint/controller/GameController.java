package com.SavePoint.SavePoint.controller;

import com.SavePoint.SavePoint.controller.response.GameResponse;
import com.SavePoint.SavePoint.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/savepoint")
public class GameController {

    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameResponse>> findAll (){

    }
}
