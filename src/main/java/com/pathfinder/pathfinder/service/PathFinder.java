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
        boolean moved = moveIfEmptySpace(false);
        if (grid.isEndPointFound()) return grid;
        if (moved) return getWithFullPath();

        moved = moveBackIfNoEmptySpace();
        if (moved) return getWithFullPath();
        return grid;
    }

    private boolean moveIfEmptySpace(boolean moved) {
        if (!moved) moved = goOneStep(directions[0]);
        if (!moved) moved = goOneStep(directions[1]);
        if (!moved) moved = goOneStep(directions[2]);
        if (!moved) moved = goOneStep(directions[3]);
        return moved;
    }

    private boolean moveBackIfNoEmptySpace() {
        boolean noWay = false;
        if (!noWay) noWay = goStepBack(directions[0]);
        if (!noWay) noWay = goStepBack(directions[1]);
        if (!noWay) noWay = goStepBack(directions[2]);
        if (!noWay) noWay = goStepBack(directions[3]);
        return noWay;
    }



}
