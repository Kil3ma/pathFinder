package com.pathfinder.pathfinder.service;

import com.pathfinder.pathfinder.model.enums.ObjectType;
import org.springframework.stereotype.Service;

@Service
public class GridCreator {

    public int[][] createGrid(int rows, int columns) {
        int[][] grid = new int[rows+2][columns+2];
        for(int i = 0; i < grid[0].length; i++){
            grid[0][i] = ObjectType.WALL.value;
            grid[grid[0].length - 1][i] = ObjectType.WALL.value;
        }
        for(int i = 0; i < grid.length; i++){
            grid[i][0] = ObjectType.WALL.value;
            grid[i][grid.length - 1] = ObjectType.WALL.value;
        }
        return grid;
    }

}
