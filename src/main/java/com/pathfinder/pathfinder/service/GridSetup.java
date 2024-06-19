package com.pathfinder.pathfinder.service;

import com.pathfinder.pathfinder.model.GridPoint;
import com.pathfinder.pathfinder.model.enums.ObjectType;
import org.springframework.stereotype.Service;

/**
 * GridSetup is a service class that provides methods to set up a grid.
 * It allows setting the starting point, ending point, and obstacles on the grid.
 */
@Service
public class  GridSetup {

    public int[][] setPoint(GridPoint gridPoint){
        int[][] grid = gridPoint.getGrid();
        grid[gridPoint.getX()][gridPoint.getY()] = gridPoint.getType().value;
        return grid;
    }

    public int[][] clearPath(int[][] grid){
        for(int[] rows: grid){
            for(int tile: rows){
                if(tile == ObjectType.PATH.value){
                    tile = ObjectType.EMPTY.value;
                }
            }
        }
        return grid;
    }

    /**
     * Sets the starting point on the grid.
     *
     * @param grid The grid on which the starting point is to be set.
     * @param x The x-coordinate of the starting point.
     * @param y The y-coordinate of the starting point.
     * @return The grid with the starting point set.
     */
    public int[][] setStartingPoint(int[][] grid, int x, int y) throws ArrayIndexOutOfBoundsException {
        grid[x][y] = ObjectType.START_POINT.value;
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
    public int[][] setEndingPoint(int[][] grid, int x, int y) throws ArrayIndexOutOfBoundsException {
        grid[x][y] = ObjectType.END_POINT.value;
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
    public int[][] setObstacle(int[][] grid, int x, int y) throws ArrayIndexOutOfBoundsException {
        grid[x][y] = ObjectType.OBSTACLE.value;
        return grid;
    }

}
