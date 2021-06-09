package com.game.treasurehunt.services;

import com.game.treasurehunt.TreasureHunt;
import com.game.treasurehunt.dto.Board;
import com.game.treasurehunt.dto.TreasurePath;
import com.game.treasurehunt.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreasureService {

  private TreasureHunt treasureHunt;

  @Autowired
  public TreasureService(TreasureHunt treasureHunt) {
    this.treasureHunt = treasureHunt;
  }

  public void addTreasureMap(Board board) {
    treasureHunt.setBoard(board);
  }

  public TreasurePath getTreasurePath() throws NotFoundException {
    return treasureHunt.getTreasurePath();
  }
}
