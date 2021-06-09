package com.game.treasurehunt.calculation;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.treasurehunt.dto.Board;
import com.game.treasurehunt.dto.Spot;
import com.game.treasurehunt.dto.TreasurePath;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class TreasurePathTrackingTest {

  TreasurePathTracking pathTracking = new TreasurePathTracking();

  @Test
  public void testCalculatePathForTreasureFound() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Board board = mapper.readValue(new File("src/main/resources/treasureBoard.json"),
                                   Board.class);
    TreasurePath path = pathTracking.calculatePath(board);
    List<Spot> spotList = path.getPath();
    assertEquals(19, spotList.size());
    assertEquals(true, path.isPathFound());
  }

  @Test
  public void testCalculatePathForTreasureNotFound() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Board board = mapper.readValue(new File("src/main/resources/treasureBoardNotFound.json"),
                                   Board.class);
    TreasurePath path = pathTracking.calculatePath(board);
    assertEquals(false, path.isPathFound());
  }

}