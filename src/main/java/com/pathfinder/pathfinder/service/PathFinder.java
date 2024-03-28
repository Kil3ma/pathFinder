package com.pathfinder.pathfinder.service;

public class PathFinder {

    private static final int FREE = 0;
    private static final int START = 1;
    private static final int END = 2;
    private static final int OBSTACLE = 3;
    private static final int PATH = 4;

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Prawo, Dół, Lewo, Góra

    public int[][] findPath(int[][] grid) {
        printGrid(grid);
        return grid;
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
