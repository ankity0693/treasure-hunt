package com.game.treasurehunt.controller;

import com.game.treasurehunt.dto.Board;
import com.game.treasurehunt.dto.TreasurePath;
import com.game.treasurehunt.exception.NotFoundException;
import com.game.treasurehunt.services.TreasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/treasure-hunt")
public class TreasureHuntController {

  private TreasureService service;

  @Autowired
  public TreasureHuntController(TreasureService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity addTreasureMap(@RequestBody Board board) {
    try {
      service.addTreasureMap(board);
      return ResponseEntity.status(201).build();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/path")
  public TreasurePath findPath() throws NotFoundException {
    try {
      return service.getTreasurePath();
    } catch (NotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
    }
  }
}
