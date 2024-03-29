package com.pathfinder.pathfinder.controller;


import com.pathfinder.pathfinder.model.Grid;
import com.pathfinder.pathfinder.model.GridPoint;
import com.pathfinder.pathfinder.service.GridCreator;
import com.pathfinder.pathfinder.service.GridSetup;
import com.pathfinder.pathfinder.service.Printer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
