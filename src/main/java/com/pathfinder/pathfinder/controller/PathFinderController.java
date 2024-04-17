package com.pathfinder.pathfinder.controller;

import com.pathfinder.pathfinder.service.PathFinder;
import com.pathfinder.pathfinder.service.Printer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/grid")
public class PathFinderController {
    private final PathFinder pathFinder;
    public PathFinderController() {this.pathFinder = new PathFinder();}

    @PostMapping
    public int[][] findPath(@RequestBody int[][] grid){
        int[][] finalGrid = pathFinder.findPath(grid);
        Printer.print(finalGrid);
        return finalGrid;
    }
}
