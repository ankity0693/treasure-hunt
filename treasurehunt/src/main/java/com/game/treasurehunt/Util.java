package com.game.treasurehunt;

public class Util {

  /*
  Commons place to get tens place of digit
   */
  public static Integer getTensPlace(Integer val) {
    return val / 10;
  }

  /*
  Commons place to get unit place of digit
   */
  public static Integer getUnitPlace(Integer val) {
    return val % 10;
  }
}
