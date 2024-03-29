package com.pathfinder.pathfinder.service;

public class Printer {
    public static void print(int grid[][]){
        for (int row: grid[0]) {
            System.out.print("- ");
        }
        System.out.println();
        for(int[] row: grid) {
            for(int column: row){
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}
