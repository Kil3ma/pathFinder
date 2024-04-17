package com.pathfinder.pathfinder.service;

import com.pathfinder.pathfinder.model.enums.ObjectType;

public class PathFinder {

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Prawo, Dół, Lewo, Góra
    private int x = 0, y = 0, endX = 0, endY = 0;

    public void findStartAndEndPoints(int[][] grid) throws IllegalArgumentException{
        boolean moreThanOneStart = false;
        boolean moreThanOneEnd = false;


        for(int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == ObjectType.START_POINT.value) {
                    if(moreThanOneStart){
                        throw new IllegalArgumentException("podano więcej niż 1 punkt startowy");
                    }
                    x = i;
                    y = j;
                    grid[i][j] = ObjectType.PATH.value;
                    moreThanOneStart = true;

                } else if (grid[i][j] == ObjectType.END_POINT.value) {
                    if(moreThanOneEnd){
                        throw new IllegalArgumentException("podano więcej niż 1 punkt końcowy");
                    }
                    grid[i][j] = ObjectType.EMPTY.value;
                    endX = i;
                    endY = j;
                    moreThanOneEnd = true;
                }
            }
        }
        if(x == endX && y == endY){
            throw new IllegalArgumentException("brak punktu startowego lub końcowego");
        }
    }
    public int[][] findPath(int[][] grid) throws IllegalStateException{
        findStartAndEndPoints(grid);

        while(grid[endX][endY] != ObjectType.PATH.value) {
            boolean noPath = true;
            boolean found = false;
            for (int[] direction : directions) {
                /*if (grid[x + direction[0]][y + direction[1]] == ObjectType.END_POINT.value) {
                    found = true;
                    break;
                }*/
                if (grid[x + direction[0]][y + direction[1]] == ObjectType.EMPTY.value) {
                    grid[x + direction[0]][y + direction[1]] = ObjectType.PATH.value;
                    x = x + direction[0];
                    y = y + direction[1];
                    noPath = false;
                    break;
                }
            }

            if (found) {
                return grid;
            }

            if(noPath){
                boolean reallyNoPath = true;
                for (int[] direction : directions) {
                    if (grid[x + direction[0]][y + direction[1]] == ObjectType.PATH.value) {
                        grid[x][y] = ObjectType.WALL.value;
                        x = x + direction[0];
                        y = y + direction[1];
                        reallyNoPath = false;
                        break;
                    }
                }
                if (reallyNoPath){
                    throw new IllegalStateException("nie ma drogi");
                }
            }
        }
        return grid;
    }

}
