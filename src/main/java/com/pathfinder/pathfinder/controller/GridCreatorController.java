package com.pathfinder.pathfinder.controller;


import com.pathfinder.pathfinder.model.Grid;
import com.pathfinder.pathfinder.service.GridCreator;
import com.pathfinder.pathfinder.service.Printer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/grid")
public class GridCreatorController {

    private final GridCreator gridCreator;
    public GridCreatorController() {
        this.gridCreator = new GridCreator();
    }

    @PostMapping
    public int[][] createGrid(@RequestBody Grid grid) {
        int[][] createdGrid = gridCreator.createGrid(grid.getWidth(), grid.getHeight());
        Printer.print(createdGrid);
        return createdGrid;
    }

}
