package com.SavePoint.SavePoint.repository;

import com.SavePoint.SavePoint.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository <Game, Long> {
}
