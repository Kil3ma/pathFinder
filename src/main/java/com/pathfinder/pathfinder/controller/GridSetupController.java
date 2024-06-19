package com.pathfinder.pathfinder.controller;


import com.pathfinder.pathfinder.model.Grid;
import com.pathfinder.pathfinder.model.GridPoint;
import com.pathfinder.pathfinder.service.GridSetup;
import com.pathfinder.pathfinder.service.Printer;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/grid-setup")
public class GridSetupController {

    private final GridSetup gridSetup;
    public GridSetupController() {
        this.gridSetup = new GridSetup();
    }

    @PostMapping("/point")
    public int[][] setStartPoint(@RequestBody GridPoint gridPoint) {
        int[][] grid = gridSetup.setPoint(gridPoint);
        Printer.print(grid);
        return grid;
    }

    @PostMapping("/clear")
    public int[][] clearPath(@RequestBody Grid gridToClear) {
        return gridSetup.clearPath(gridToClear.getGrid());
    }

}
