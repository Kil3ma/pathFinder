package com.pathfinder.pathfinder.service;

import org.springframework.stereotype.Service;

@Service
public class GridCreator {

    public int[][] createGrid(int rows, int columns) {
        int[][] grid = new int[rows][columns];
        return grid;
    }

}
