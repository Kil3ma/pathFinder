package com.pathfinder.pathfinder.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridCreatorTest {

    @Test
    void createGridShouldReturnCorrectSize() {
        GridCreator gridCreator = new GridCreator();
        int[][] grid = gridCreator.createGrid(5, 5);
        assertEquals(5, grid.length);
        assertEquals(5, grid[0].length);
    }

    @Test
    void createGridShouldInitializeWithZeros() {
        GridCreator gridCreator = new GridCreator();
        int[][] grid = gridCreator.createGrid(3, 3);
        for (var ints : grid) {
            for (var anInt : ints) {
                assertEquals(0, anInt);
            }
        }
    }

    @Test
    void createGridShouldHandleZeroSize() {
        GridCreator gridCreator = new GridCreator();
        int[][] grid = gridCreator.createGrid(0, 0);
        assertEquals(0, grid.length);
    }

    @Test
    void createGridShouldHandleNonSquareSize() {
        GridCreator gridCreator = new GridCreator();
        int[][] grid = gridCreator.createGrid(3, 5);
        assertEquals(3, grid.length);
        assertEquals(5, grid[0].length);
    }

}