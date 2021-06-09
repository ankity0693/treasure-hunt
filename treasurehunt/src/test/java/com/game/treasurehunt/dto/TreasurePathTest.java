package com.game.treasurehunt.dto;

import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.Test;

public class TreasurePathTest {

  @Test
  public void testTreasurePathSerialisationAndDeserialisation() throws JsonProcessingException {
    TreasurePath path = new TreasurePath();
    List<Spot> spots = List.of(new Spot(1, 1, 21));
    String message = "msg";

    path.setMessage(message);
    path.setPathFound(true);
    path.setPath(spots);

    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(path);

    TreasurePath actual = mapper.readValue(json, TreasurePath.class);
    assertEquals(path, actual);
  }

}