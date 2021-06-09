package com.game.treasurehunt.dto;

import com.google.common.base.Objects;
import java.util.List;

/*
This class will be instansiated when we have completed the treasure path tracking.
This will contain the result of path tracking whether path is available or not.
If path is available then what is the path followed is present in path list.
 */
public class TreasurePath {
  String message;
  boolean isPathFound;
  List<Spot> path;

  public boolean isPathFound() {
    return isPathFound;
  }

  public void setPathFound(boolean pathFound) {
    isPathFound = pathFound;
  }

  public List<Spot> getPath() {
    return path;
  }

  public void setPath(List<Spot> path) {
    this.path = path;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreasurePath)) {
      return false;
    }
    TreasurePath that = (TreasurePath) o;
    return isPathFound == that.isPathFound &&
        Objects.equal(message, that.message) &&
        Objects.equal(path, that.path);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(message, isPathFound, path);
  }
}
