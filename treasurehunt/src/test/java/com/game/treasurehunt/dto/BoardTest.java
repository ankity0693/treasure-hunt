package com.game.treasurehunt.dto;

import static com.game.treasurehunt.dto.Constant.BOARD_SIZE;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.treasurehunt.exception.DataIncorrectException;
import java.io.File;
import java.io.IOException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BoardTest {

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  /*
  Testing for serialisation and deserialization of valid treasure-map data.
   */
  @Test
  public void testBoardSerializeAndDeserialise()
      throws JsonProcessingException, DataIncorrectException {
    Board board = new Board();

    Spot[][] treasureBoard = new Spot[BOARD_SIZE][BOARD_SIZE];
    int row = 0;
    treasureBoard[row][0] = new Spot(row + 1, 1, 34);
    treasureBoard[row][1] = new Spot(row + 1, 2, 21);
    treasureBoard[row][2] = new Spot(row + 1, 3, 32);
    treasureBoard[row][3] = new Spot(row + 1, 4, 41);
    treasureBoard[row][4] = new Spot(row + 1, 5, 25);

    row = 1;
    treasureBoard[row][0] = new Spot(row + 1, 1, 14);
    treasureBoard[row][1] = new Spot(row + 1, 2, 42);
    treasureBoard[row][2] = new Spot(row + 1, 3, 43);
    treasureBoard[row][3] = new Spot(row + 1, 4, 14);
    treasureBoard[row][4] = new Spot(row + 1, 5, 31);

    row = 2;
    treasureBoard[row][0] = new Spot(row + 1, 1, 54);
    treasureBoard[row][1] = new Spot(row + 1, 2, 45);
    treasureBoard[row][2] = new Spot(row + 1, 3, 52);
    treasureBoard[row][3] = new Spot(row + 1, 4, 42);
    treasureBoard[row][4] = new Spot(row + 1, 5, 23);

    row = 3;
    treasureBoard[row][0] = new Spot(row + 1, 1, 33);
    treasureBoard[row][1] = new Spot(row + 1, 2, 15);
    treasureBoard[row][2] = new Spot(row + 1, 3, 51);
    treasureBoard[row][3] = new Spot(row + 1, 4, 31);
    treasureBoard[row][4] = new Spot(row + 1, 5, 35);

    row = 4;
    treasureBoard[row][0] = new Spot(row + 1, 1, 21);
    treasureBoard[row][1] = new Spot(row + 1, 2, 52);
    treasureBoard[row][2] = new Spot(row + 1, 3, 33);
    treasureBoard[row][3] = new Spot(row + 1, 4, 13);
    treasureBoard[row][4] = new Spot(row + 1, 5, 23);


    board.setTreasureBoard(treasureBoard);

    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(board);

    Board actualBoard = mapper.readValue(json, Board.class);

    assertEquals(board, actualBoard);
  }

  /*
  Tests to check validation of data in each spots while deserialising the json data.
   "row":1,
   "col":1,
   "val":65
   Value at unit and tens place should be in range 1 and 5 (including 1 and 5). 5 is board size.
   */
  @Test
  public void testBoardWithIncorrectValueDeserialisation()
      throws DataIncorrectException, IOException {
    expectedEx.expect(JsonMappingException.class);
    expectedEx.expectMessage("Tens place is incorrect at row: 1, col: 1");
    ObjectMapper mapper = new ObjectMapper();

    mapper.readValue(new File("src/main/resources/treasureBoardIncorrectData.json")
        , Board.class);
  }

  /*
    Checks is treasure map data provided matching with board size.
    Setting board size more than 5 i.e. 6. Expecting exception should be thrown.
   */
  @Test
  public void testBoardSizeNotMatching() throws DataIncorrectException {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("Given treasureBoard size is not matching with the boardSize : 5");
    Board board = new Board();
    Spot[][] treasureBoard = new Spot[6][6];
    int row = 0;
    treasureBoard[row][0] = new Spot(row + 1, 1, 34);
    treasureBoard[row][1] = new Spot(row + 1, 2, 21);
    treasureBoard[row][2] = new Spot(row + 1, 3, 32);
    treasureBoard[row][3] = new Spot(row + 1, 4, 41);
    treasureBoard[row][4] = new Spot(row + 1, 5, 25);

    row = 1;
    treasureBoard[row][0] = new Spot(row + 1, 1, 14);
    treasureBoard[row][1] = new Spot(row + 1, 2, 42);
    treasureBoard[row][2] = new Spot(row + 1, 3, 43);
    treasureBoard[row][3] = new Spot(row + 1, 4, 14);
    treasureBoard[row][4] = new Spot(row + 1, 5, 31);

    row = 2;
    treasureBoard[row][0] = new Spot(row + 1, 1, 54);
    treasureBoard[row][1] = new Spot(row + 1, 2, 45);
    treasureBoard[row][2] = new Spot(row + 1, 3, 52);
    treasureBoard[row][3] = new Spot(row + 1, 4, 42);
    treasureBoard[row][4] = new Spot(row + 1, 5, 23);

    row = 3;
    treasureBoard[row][0] = new Spot(row + 1, 1, 33);
    treasureBoard[row][1] = new Spot(row + 1, 2, 15);
    treasureBoard[row][2] = new Spot(row + 1, 3, 51);
    treasureBoard[row][3] = new Spot(row + 1, 4, 31);
    treasureBoard[row][4] = new Spot(row + 1, 5, 35);

    row = 4;
    treasureBoard[row][0] = new Spot(row + 1, 1, 21);
    treasureBoard[row][1] = new Spot(row + 1, 2, 52);
    treasureBoard[row][2] = new Spot(row + 1, 3, 33);
    treasureBoard[row][3] = new Spot(row + 1, 4, 13);
    treasureBoard[row][4] = new Spot(row + 1, 5, 23);

    row = 5;
    treasureBoard[row][0] = new Spot(row + 1, 1, 21);
    treasureBoard[row][1] = new Spot(row + 1, 2, 52);
    treasureBoard[row][2] = new Spot(row + 1, 3, 33);
    treasureBoard[row][3] = new Spot(row + 1, 4, 13);
    treasureBoard[row][4] = new Spot(row + 1, 5, 23);

    board.setTreasureBoard(treasureBoard);

  }

}