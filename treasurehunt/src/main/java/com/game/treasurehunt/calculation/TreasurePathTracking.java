package com.game.treasurehunt.calculation;

import com.game.treasurehunt.Util;
import com.game.treasurehunt.dto.Board;
import com.game.treasurehunt.dto.Spot;
import com.game.treasurehunt.dto.TreasurePath;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
This class contains Treasure hunt path calculation algorithm.
 */
@Component
public class TreasurePathTracking {

  /**
   * Method to calculate the path followed while finding the treasure.
   * We are starting from top left (1,1) and proceeding to next path as per the rule.
   * <p> for each value the tens digit represents the row number and the unit digit represents
   * the column number of the cell containing the would be next clue.</p>
   * <p>
   * If path is not found there could be the possibility its forming the circle hence is spot
   * is visited again during the iteration we are breaking the path finding algo.
   *
   * @param board {@link Board} Treasure Map board.
   * @return Treasure path followed to find the treasure.
   */
  public TreasurePath calculatePath(Board board) {
    List<Spot> pathTracker = new ArrayList<>();
    Spot currentSpot = board.getSpot(1, 1);

    while (!currentSpot.isVisited()) {
      currentSpot.setVisited(true);
      pathTracker.add(currentSpot);
      Integer onesPlace = Util.getUnitPlace(currentSpot.getVal());
      Integer tensPlace = Util.getTensPlace(currentSpot.getVal());
      if (isDestination(currentSpot)) {
        return formTreasurePathDto(pathTracker, true, currentSpot);
      }
      currentSpot = board.getSpot(tensPlace, onesPlace);
    }
    return formTreasurePathDto(pathTracker, false, currentSpot);
  }

  /**
   * Forming TreasurePath Dto from resulted data.
   *
   * @param pathTracker List of path tracked during treasure hunt
   * @param isPathFound boolean if path found else false
   * @param currentSpot spot where we found the treasure
   * @return
   */
  private TreasurePath formTreasurePathDto(List<Spot> pathTracker, boolean isPathFound,
                                           Spot currentSpot) {
    TreasurePath path = new TreasurePath();
    if (isPathFound) {
      path.setPath(pathTracker);
      path.setPathFound(isPathFound);
      path.setMessage("Treasure found at spot: " + currentSpot.toString());
      return path;
    }
    path.setMessage("No treasure path found");
    return path;
  }

  /**
   * Checking if this is destination spot, is this the spot where treasure is present.
   *
   * @param currentSpot {@link Spot}
   * @return true if treasure is present here
   */
  private boolean isDestination(Spot currentSpot) {
    Integer tensPlace = Util.getTensPlace(currentSpot.getVal());
    Integer unitPlace = Util.getUnitPlace(currentSpot.getVal());
    return currentSpot.getRow().equals(tensPlace)
        && currentSpot.getCol().equals(unitPlace);
  }
}
