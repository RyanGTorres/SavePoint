package com.SavePoint.SavePoint.service;

import com.SavePoint.SavePoint.entity.Game;
import com.SavePoint.SavePoint.repository.GameRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Optional<Game> findById(Game game, Long id){
        return gameRepository.findById(id);
    }

    public void deleteById(Long id){
        gameRepository.deleteById(id);
    }
}
