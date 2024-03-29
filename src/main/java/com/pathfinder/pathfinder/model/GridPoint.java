package com.pathfinder.pathfinder.model;

import com.pathfinder.pathfinder.model.enums.ObjectType;

public class GridPoint {
    private final int[][] grid;
    private final int x;
    private final int y;
    private final ObjectType type;

    public GridPoint(int[][] grid, int x, int y, ObjectType type) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int[][] getGrid(){
        return this.grid;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public ObjectType getType(){
        return this.type;
    }
}
