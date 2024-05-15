package com.pathfinder.pathfinder.controller;

import com.pathfinder.pathfinder.model.Grid;
import com.pathfinder.pathfinder.service.PathFinder;
import com.pathfinder.pathfinder.service.Printer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/path")
public class PathFinderController {


    @PostMapping
    public int[][] findPath(@RequestBody Grid grid){
        PathFinder pathFinder = new PathFinder(grid);
        int[][] finalGrid = pathFinder.getWithFullPath().getGrid();
        Printer.print(finalGrid);
        return finalGrid;
    }
}
