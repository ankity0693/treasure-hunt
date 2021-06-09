package com.game.treasurehunt.dto;

import java.util.List;

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
}
