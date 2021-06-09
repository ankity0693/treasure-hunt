package com.game.treasurehunt.dto;

import static com.game.treasurehunt.dto.Constant.BOARD_SIZE;

import com.google.common.base.Objects;

/*
Board class will contain the treasure map data.
 */
public class Board {

  private Spot[][] treasureBoard;

  public Board() {
  }

  public Spot[][] getTreasureBoard() {
    return treasureBoard;
  }

  /**
   * Sets treasure map data and this does the validation also whether treasure board is of
   * required size or not.
   *
   * @param treasureBoard {@link Spot[][]}
   * @throws IllegalArgumentException Exception thrown if board size is not as expected
   */
  public void setTreasureBoard(Spot[][] treasureBoard)
      throws IllegalArgumentException {
    validateBoardSize(treasureBoard);
    this.treasureBoard = treasureBoard;
  }

  /*
  This method checks if we have required board size or not.
   */
  private void validateBoardSize(Spot[][] treasureBoard) {
    if (treasureBoard.length != BOARD_SIZE) {
      throw new IllegalArgumentException(
          "Given treasureBoard size is not matching with the boardSize : " + BOARD_SIZE);
    }
    for(int i = 0 ; i < BOARD_SIZE; i++) {
      if(treasureBoard[i].length != BOARD_SIZE) {
        throw new IllegalArgumentException(
            "Given treasureBoard size is not matching with the boardSize : " + BOARD_SIZE);
      }
    }
  }

  public Spot getSpot(int row, int col) {
    return treasureBoard[row - 1][col - 1];
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Board)) {
      return false;
    }
    Board board = (Board) o;

    if (treasureBoard.length != board.treasureBoard.length) {
      return false;
    }
    if (treasureBoard.length == 0) {
      return true;
    }

    if (treasureBoard[0].length != board.treasureBoard[0].length) {
      return false;
    }
    return isBoardDataEquals(treasureBoard, board.treasureBoard);
  }

  /*
  Checks for objects spot values are same or not.
   */
  private boolean isBoardDataEquals(Spot[][] treasureBoard, Spot[][] treasureBoard1) {
    for (int row = 0; row < treasureBoard.length; row++) {
      for (int col = 0; col < treasureBoard[0].length; col++) {
        if (!(treasureBoard[row][col].equals(treasureBoard1[row][col]))) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(treasureBoard);
  }
}
