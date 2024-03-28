package com.pathfinder.pathfinder.service;

public class PathFinder {

    private static final int FREE = 0;
    private static final int START = 1;
    private static final int END = 2;
    private static final int OBSTACLE = 3;
    private static final int PATH = 4;

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Prawo, Dół, Lewo, Góra

    public int[][] findPath(int[][] grid) {
        int[] startPos = findStart(grid);
        if (startPos == null) throw new IllegalStateException("Start position not found.");

        boolean pathFound = search(grid, startPos[0], startPos[1]);
        if (!pathFound) {
            throw new IllegalStateException("No path found from start to end.");
        }

        printGrid(grid);
        return grid;
    }

    private boolean search(int[][] grid, int x, int y) {
        int dir = 0;
        while (grid[x][y] != END) {
            int nextX;
            int nextY;
            int[] nextDir = directions[dir];
            nextX = x + nextDir[0];
            nextY = y + nextDir[1];

            if (isValidMove(grid, nextX, nextY)) {
                grid[x][y] = PATH;
                x = nextX;
                y = nextY;
            } else {
                dir = (dir + 1) % 4;
            }

            boolean isStuck = true;
            for (int[] direction : directions) {
                nextX = x + direction[0];
                nextY = y + direction[1];
                if (isValidMove(grid, nextX, nextY)) {
                    isStuck = false;
                    break;
                }
            }

            if (isStuck) {
                return false;
            }
        }
        grid[x][y] = PATH;
        return true;
    }

    private int[] findStart(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == START) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean isValidMove(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && (grid[x][y] == FREE || grid[x][y] == END);
    }

    public void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                switch (cell) {
                    case START:
                        System.out.print("1 "); // Start
                        break;
                    case END:
                        System.out.print("2 "); // Koniec
                        break;
                    case OBSTACLE:
                        System.out.print("3 "); // Przeszkoda
                        break;
                    case PATH:
                        System.out.print("4 "); // Ścieżka
                        break;
                    default:
                        System.out.print("0 "); // Wolna przestrzeń
                }
            }
            System.out.println();
        }
    }
}
