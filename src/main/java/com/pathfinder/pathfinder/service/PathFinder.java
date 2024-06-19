package com.pathfinder.pathfinder.service;

import com.pathfinder.pathfinder.model.Grid;
import com.pathfinder.pathfinder.model.enums.ObjectType;
import com.pathfinder.pathfinder.utils.Pair;

import java.util.Optional;

public class PathFinder {

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Prawo, Dół, Lewo, Góra
    private int x = 0, y = 0, endX = 0, endY = 0;
    private Grid grid;

    public PathFinder(Grid grid){
        this.grid = grid;
    }

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
    public boolean goOneStep(int[] direction){
        Optional<Pair<Integer, Integer>> pointOpt = grid.getCoordinatesOfStartingPointOrHero();
        if (pointOpt.isEmpty()) return false;
        Pair<Integer, Integer> point = pointOpt.get();
        int ongoingTile = grid.getGrid()[point.getFirst() + direction[0]][point.getSecond()+direction[1]];
        if(ongoingTile == ObjectType.OBSTACLE.value || ongoingTile == ObjectType.WALL.value || ongoingTile == ObjectType.PATH.value) return false;
        if(isThereEndPoint(point)){
            grid.setEndPointFound(true);
            return true;
        }
        grid.getGrid()[point.getFirst()+direction[0]][point.getSecond()+direction[1]] = ObjectType.HERO.value;
        grid.getGrid()[point.getFirst()][point.getSecond()] = ObjectType.PATH.value;
        return true;
    }

    public boolean goStepBack(int[] direction){
        Optional<Pair<Integer, Integer>> pointOpt = grid.getCoordinatesOfStartingPointOrHero();
        if (pointOpt.isEmpty()) return false;
        Pair<Integer, Integer> point = pointOpt.get();
        int ongoingTile = grid.getGrid()[point.getFirst() + direction[0]][point.getSecond()+direction[1]];
        if(ongoingTile == ObjectType.WALL.value || ongoingTile == ObjectType.OBSTACLE.value) return false;
        if(ongoingTile == ObjectType.PATH.value){
            grid.getGrid()[point.getFirst()+direction[0]][point.getSecond()+direction[1]] = ObjectType.HERO.value;
            grid.getGrid()[point.getFirst()][point.getSecond()] = ObjectType.WALL.value;
            return true;
        }
        return false;
    }

    public boolean isThereEndPoint(Pair<Integer,Integer> heroCoordinates){
        for(int[] direction : directions){
            if(grid.getGrid()[heroCoordinates.getFirst() + direction[0]][heroCoordinates.getSecond()+direction[1]] == ObjectType.END_POINT.value){
                return true;
            }
        }
        return false;
    }

    public Grid getWithFullPath() {
        boolean moved = false;
        boolean noWay = false;

        if (!moved) moved = goOneStep(directions[0]);
        if (!moved) moved = goOneStep(directions[1]);
        if (!moved) moved = goOneStep(directions[2]);
        if (!moved) moved = goOneStep(directions[3]);
        if (!moved && !noWay) noWay = goStepBack(directions[0]);
        if (!moved && !noWay) noWay = goStepBack(directions[1]);
        if (!moved && !noWay) noWay = goStepBack(directions[2]);
        if (!moved && !noWay) noWay = goStepBack(directions[3]);

        if (moved && !grid.isEndPointFound())  return getWithFullPath();
        return grid;
    }



}
