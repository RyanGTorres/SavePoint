package com.SavePoint.SavePoint.controller;

import com.SavePoint.SavePoint.controller.interfaces.GameController;
import com.SavePoint.SavePoint.controller.request.GameRequest;
import com.SavePoint.SavePoint.controller.response.GameResponse;
import com.SavePoint.SavePoint.entity.Game;
import com.SavePoint.SavePoint.mapper.GameMapper;
import com.SavePoint.SavePoint.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/savepoint/game")
@RequiredArgsConstructor

public class GameControllerImpl implements GameController {

    private final GameService gameService;


    @PostMapping
    public ResponseEntity<GameResponse> save (@Valid @RequestBody GameRequest gameRequest){
            Game gameSaved = gameService.save(GameMapper.toGame(gameRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(GameMapper.toGameResponse(gameSaved));
    }

    @PostMapping("/{id}")
    public ResponseEntity<GameResponse> update (@PathVariable Long id,@Valid @RequestBody GameRequest request){
            return gameService.update(id, GameMapper.toGame(request))
                    .map(game -> ResponseEntity.ok(GameMapper.toGameResponse(game)))
                    .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity <List<GameResponse>> findAll (){
        return ResponseEntity.ok(gameService.findAll().stream()
                .map(GameMapper::toGameResponse)
                .toList());
    }



    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> findById(@PathVariable Long id){
        return gameService.findById(id)
                .map(encontrado -> ResponseEntity.ok(GameMapper.toGameResponse(encontrado)))
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Game> optGame = gameService.findById(id);
        if (optGame.isPresent()){
            gameService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
     }
}
