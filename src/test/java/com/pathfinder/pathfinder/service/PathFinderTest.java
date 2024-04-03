package com.pathfinder.pathfinder.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathFinderTest {

    @Test
    void findPathShouldReturnCorrectPath() {
        PathFinder pathFinder = new PathFinder();
        int[][] grid = {
                {9, 9, 9, 9, 9, 9, 9},
                {9, 1, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 3, 0, 9},
                {9, 0, 3, 0, 3, 0, 9},
                {9, 0, 3, 3, 3, 0, 9},
                {9, 0, 0, 0, 0, 2, 9},
                {9, 9, 9, 9, 9, 9, 9}
        };
        int[][] expectedGrid = {
                {9, 9, 9, 9, 9, 9, 9},
                {9, 4, 4, 4, 4, 4, 9},
                {9, 0, 0, 0, 3, 4, 9},
                {9, 0, 3, 0, 3, 4, 9},
                {9, 0, 3, 3, 3, 4, 9},
                {9, 0, 0, 0, 0, 4, 9},
                {9, 9, 9, 9, 9, 9, 9}
        };
        assertArrayEquals(expectedGrid, pathFinder.findPath(grid));
    }

    @Test
    void findPathShouldReturnCorrectPath2() {
        PathFinder pathFinder = new PathFinder();
        int[][] grid = {
                {9, 9, 9, 9, 9, 9, 9},
                {9, 1, 0, 0, 0, 0, 9},
                {9, 0, 0, 0, 3, 3, 9},
                {9, 0, 3, 0, 3, 0, 9},
                {9, 0, 3, 3, 3, 0, 9},
                {9, 0, 0, 0, 0, 2, 9},
                {9, 9, 9, 9, 9, 9, 9}
        };
        int[][] expectedGrid = {
                {9, 9, 9, 9, 9, 9, 9},
                {9, 4, 4, 4, 9, 9, 9},
                {9, 4, 4, 4, 3, 3, 9},
                {9, 4, 3, 9, 3, 0, 9},
                {9, 4, 3, 3, 3, 0, 9},
                {9, 4, 4, 4, 4, 4, 9},
                {9, 9, 9, 9, 9, 9, 9}
        };
        assertArrayEquals(expectedGrid, pathFinder.findPath(grid));
    }




    @Test
    void findPathShouldHandleNoPath() {
        PathFinder pathFinder = new PathFinder();
        int[][] grid = {
                {9, 9, 9, 9, 9, 9, 9},
                {9, 1, 0, 0, 0, 0, 9},
                {9, 0, 3, 3, 3, 0, 9},
                {9, 0, 3, 0, 3, 0, 9},
                {9, 0, 3, 3, 3, 3, 9},
                {9, 0, 0, 0, 3, 2, 9},
                {9, 9, 9, 9, 9, 9, 9}
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

    @Test
    void findPathShouldHandleTooManyStartsOrEnds(){
        PathFinder pathFinder = new PathFinder();
        int[][] grid = {
                {9, 9, 9, 9, 9, 9, 9},
                {9, 1, 0, 2, 0, 1, 9},
                {9, 0, 3, 3, 3, 0, 9},
                {9, 0, 3, 0, 3, 0, 9},
                {9, 0, 3, 3, 3, 3, 9},
                {9, 0, 2, 0, 3, 2, 9},
                {9, 9, 9, 9, 9, 9, 9}
        };
        assertThrows(IllegalArgumentException.class, () -> pathFinder.findPath(grid));
    }

}