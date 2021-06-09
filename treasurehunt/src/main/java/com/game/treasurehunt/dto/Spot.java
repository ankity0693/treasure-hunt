package com.game.treasurehunt.dto;

import static com.game.treasurehunt.dto.Constant.BOARD_SIZE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.treasurehunt.Util;
import com.game.treasurehunt.exception.DataIncorrectException;
import com.google.common.base.Objects;
import org.springframework.lang.NonNull;

public class Spot {
  Integer row;
  Integer col;
  Integer val;
  @JsonIgnore
  boolean isVisited;

  public Spot() {
    //default const
  }

  public Spot(Integer row, Integer col, Integer val) {
    this.row = row;
    this.col = col;
    this.val = val;
  }

  @JsonIgnore
  public boolean isVisited() {
    return isVisited;
  }

  @JsonIgnore
  public void setVisited(boolean visited) {
    isVisited = visited;
  }

  public Integer getVal() {
    return val;
  }

  public void setVal(@NonNull Integer val) throws DataIncorrectException {
    validateUnitPlace(Util.getUnitPlace(val));
    validateTensPlace(Util.getTensPlace(val));
    this.val = val;
  }

  public Integer getRow() {
    return row;
  }

  public void setRow(Integer row) {
    this.row = row;
  }

  public Integer getCol() {
    return col;
  }

  public void setCol(Integer col) {
    this.col = col;
  }

  private void validateUnitPlace(int digit) throws DataIncorrectException {
    if (!(digit >= 1 && digit <= BOARD_SIZE)) {
      throw new DataIncorrectException(
          String.format("Tens place is incorrect at row: %d, col: %d", row, col));
    }
  }

  private void validateTensPlace(int digit) throws DataIncorrectException {
    if (!(digit >= 1 && digit <= BOARD_SIZE)) {
      throw new DataIncorrectException(
          String.format("Tens place is incorrect at row: %d, col: %d", row, col));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Spot)) {
      return false;
    }
    Spot spot = (Spot) o;
    return Objects.equal(row, spot.row) &&
        Objects.equal(col, spot.col) &&
        Objects.equal(val, spot.val);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(row, col, val);
  }

  @Override
  public String toString() {
    return '{' + "row=" + row +
        ", col=" + col +
        ", val=" + val + '}';
  }
}
