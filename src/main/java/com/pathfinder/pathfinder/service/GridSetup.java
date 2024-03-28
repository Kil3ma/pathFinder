package com.pathfinder.pathfinder.service;

import org.springframework.stereotype.Service;

/**
 * GridSetup is a service class that provides methods to set up a grid.
 * It allows setting the starting point, ending point, and obstacles on the grid.
 */
@Service
public class GridSetup {

    /**
     * Sets the starting point on the grid.
     *
     * @param grid The grid on which the starting point is to be set.
     * @param x The x-coordinate of the starting point.
     * @param y The y-coordinate of the starting point.
     * @return The grid with the starting point set.
     */
    public int[][] setStartingPoint(int[][] grid, int x, int y) {
        return grid;
    }

    /**
     * Sets the ending point on the grid.
     *
     * @param grid The grid on which the ending point is to be set.
     * @param x The x-coordinate of the ending point.
     * @param y The y-coordinate of the ending point.
     * @return The grid with the ending point set.
     */
    public int[][] setEndingPoint(int[][] grid, int x, int y) {
        return grid;
    }

    /**
     * Sets an obstacle on the grid.
     *
     * @param grid The grid on which the obstacle is to be set.
     * @param x The x-coordinate of the obstacle.
     * @param y The y-coordinate of the obstacle.
     * @return The grid with the obstacle set.
     */
    public int[][] setObstacle(int[][] grid, int x, int y) {
        return grid;
    }

}
