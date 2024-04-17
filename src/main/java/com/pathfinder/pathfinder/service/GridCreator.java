package com.pathfinder.pathfinder.service;

import com.pathfinder.pathfinder.model.enums.ObjectType;
import org.springframework.stereotype.Service;

@Service
public class GridCreator {

    public int[][] createGrid(int rows, int columns) {
        int width = rows + 2;
        int height = columns + 2;
        int[][] grid = new int[width][height];
        for(int i = 0; i < grid[0].length; i++){
            grid[0][i] = ObjectType.WALL.value;
            grid[width - 1][i] = ObjectType.WALL.value;
        }
        for(int i = 0; i < grid.length; i++){
            grid[i][0] = ObjectType.WALL.value;
            grid[i][height - 1] = ObjectType.WALL.value;
        }
        return grid;
    }

}
