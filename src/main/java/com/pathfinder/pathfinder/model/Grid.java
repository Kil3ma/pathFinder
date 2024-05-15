package com.pathfinder.pathfinder.model;

import com.pathfinder.pathfinder.model.enums.ObjectType;
import com.pathfinder.pathfinder.utils.Pair;

import java.util.Optional;

public class Grid {

    private int width;
    private int height;
    private int[][] grid;

    private boolean endPointFound = false;

    public Optional<Pair<Integer, Integer>> getCoordinatesOfStartingPointOrHero() {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == ObjectType.START_POINT.value || grid[i][j] == ObjectType.HERO.value){
                    return Optional.of(new Pair<>(i, j));
                }
            }
        }
        return Optional.empty();
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isEndPointFound() {
        return endPointFound;
    }

    public void setEndPointFound(boolean endPointFound) {
        this.endPointFound = endPointFound;
    }
}
