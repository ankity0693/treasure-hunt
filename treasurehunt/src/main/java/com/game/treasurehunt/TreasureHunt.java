package com.game.treasurehunt;

import com.game.treasurehunt.calculation.TreasurePathTracking;
import com.game.treasurehunt.dto.Board;
import com.game.treasurehunt.dto.TreasurePath;
import com.game.treasurehunt.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TreasureHunt {
  Board board;
  TreasurePathTracking tracker;

  @Autowired
  TreasureHunt(TreasurePathTracking tracker) {
    this.tracker = tracker;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public TreasurePath getTreasurePath() throws NotFoundException {
    if(board == null) {
      throw new NotFoundException("Treasure Map content not found please add the data");
    }
    return tracker.calculatePath(board);
  }

}
