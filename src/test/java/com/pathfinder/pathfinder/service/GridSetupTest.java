package com.pathfinder.pathfinder.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridSetupTest {

    @Test
    void setStartingPointShouldMarkGridCorrectly() {
        GridSetup gridSetup = new GridSetup();
        int[][] grid = new int[5][5];
        grid = gridSetup.setStartingPoint(grid, 2, 2);
        assertEquals(1, grid[2][2]);
    }

    @Test
    void setEndingPointShouldMarkGridCorrectly() {
        GridSetup gridSetup = new GridSetup();
        int[][] grid = new int[5][5];
        grid = gridSetup.setEndingPoint(grid, 4, 4);
        assertEquals(2, grid[4][4]);
    }

    @Test
    void setObstacleShouldMarkGridCorrectly() {
        GridSetup gridSetup = new GridSetup();
        int[][] grid = new int[5][5];
        grid = gridSetup.setObstacle(grid, 3, 3);
        assertEquals(3, grid[3][3]);
    }

    @Test
    void setStartingPointShouldThrowExceptionForOutOfBounds() {
        GridSetup gridSetup = new GridSetup();
        int[][] grid = new int[5][5];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> gridSetup.setStartingPoint(grid, 7, 7));
    }

    @Test
    void setEndingPointShouldThrowExceptionForOutOfBounds() {
        GridSetup gridSetup = new GridSetup();
        int[][] grid = new int[5][5];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> gridSetup.setEndingPoint(grid, 7, 7));
    }

    @Test
    void setObstacleShouldThrowExceptionForOutOfBounds() {
        GridSetup gridSetup = new GridSetup();
        int[][] grid = new int[5][5];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> gridSetup.setObstacle(grid, 7, 7));
    }

    @Test
    void setObstacleShouldThrowExceptionForNullValue() {
        GridSetup gridSetup = new GridSetup();
        int[][] grid = new int[5][5];
        assertThrows(NullPointerException.class, () -> gridSetup.setObstacle(null, 7, 7));
        assertThrows(NullPointerException.class, () -> gridSetup.setObstacle(null, 5, 7));
    }

}