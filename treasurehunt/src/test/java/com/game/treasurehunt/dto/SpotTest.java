package com.game.treasurehunt.dto;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.treasurehunt.exception.DataIncorrectException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SpotTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Test
  public void testSpotSerialisationAndDeserialisation() throws JsonProcessingException {
    Spot spot = new Spot(1,1,21);
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(spot);

    Spot actual = mapper.readValue(json, Spot.class);
    assertEquals(spot, actual);
  }

  @Test
  public void testInvalidSpotValue() throws DataIncorrectException {
    expectedEx.expect(DataIncorrectException.class);
    expectedEx.expectMessage("Tens place is incorrect at row: 2, col: 3");
    Spot spot = new Spot();
    spot.setRow(2);
    spot.setCol(3);
    spot.setVal(56);
  }

  @Test(expected = NullPointerException.class)
  public void testInsertingNullToColumn() {
    Spot spot = new Spot();
    spot.setCol(null);
  }


  @Test(expected = NullPointerException.class)
  public void testInsertingNullToRow() {
    Spot spot = new Spot();
    spot.setRow(null);
  }

  @Test(expected = NullPointerException.class)
  public void testInsertingNullToTreasureClue() throws DataIncorrectException {
    Spot spot = new Spot();
    spot.setVal(null);
  }
}