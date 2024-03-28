package com.pathfinder.pathfinder.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathFinderTest {

    @Test
    void findPathShouldReturnCorrectPath() {
        PathFinder pathFinder = new PathFinder();
        int[][] grid = {
                {1, 0, 0, 0, 0},
                {0, 0, 0, 3, 0},
                {0, 3, 0, 3, 0},
                {0, 3, 3, 3, 0},
                {0, 0, 0, 0, 2}
        };
        int[][] expectedGrid = {
                {4, 4, 4, 4, 4},
                {0, 0, 0, 3, 4},
                {0, 3, 0, 3, 4},
                {0, 3, 3, 3, 4},
                {0, 0, 0, 0, 4}
        };
        assertArrayEquals(expectedGrid, pathFinder.findPath(grid));
    }

    @Test
    void findPathShouldHandleNoPath() {
        PathFinder pathFinder = new PathFinder();
        int[][] grid = {
                {1, 0, 0, 0, 0},
                {0, 3, 3, 3, 0},
                {0, 3, 0, 3, 0},
                {0, 3, 3, 3, 3},
                {0, 0, 0, 3, 2}
        };
        assertThrows(IllegalStateException.class, () -> pathFinder.findPath(grid));
    }

    @Test
    void findPathShouldHandleEmptyGrid() {
        PathFinder pathFinder = new PathFinder();
        int[][] grid = new int[0][0];
        assertThrows(IllegalArgumentException.class, () -> pathFinder.findPath(grid));
    }

    @Test
    void findPathShouldHandleGridWithoutStartOrEnd() {
        PathFinder pathFinder = new PathFinder();
        int[][] grid = new int[5][5];
        assertThrows(IllegalArgumentException.class, () -> pathFinder.findPath(grid));
    }

}