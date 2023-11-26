package main.board;

import main.board.cell.Cell;

public class Board {
    private final int height;
    private final int width;
    private final int mineCount;
    private final Cell[][] grid;

    public Board(int height, int width, int mineCount) {
        this.height = height;
        this.width = width;
        this.mineCount = mineCount;
        this.grid = generateGrid();
    }

    /**
     * Generates a grid which contains randomly spread bombs.
     * @return grid
     */
    private Cell[][] generateGrid() {
        Cell[][] grid = new Cell[height][width];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell();
            }
        }
        for (int i = 0; i < mineCount; i++) {
            int row = (int) (Math.random() * (height - 1));
            int col = (int) (Math.random() * (width - 1));
            boolean hasBomb = grid[row][col].hasBomb();
            while (hasBomb) {
                row = (int) (Math.random() * (height - 1));
                col = (int) (Math.random() * (width - 1));
                hasBomb = grid[row][col].hasBomb();
            }
            grid[row][col].setBomb();
        }
        return grid;
    }

    public void openCell(int row, int col) {
        grid[row][col].open();
    }

    public void markCell(int row, int col) {
        grid[row][col].setMark(true);
    }

    public void unMarkCell(int row, int col) {
        grid[row][col].setMark(false);
    }

    private boolean checkWin() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j].isOpened() || grid[i][j].hasBomb()) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    private void print() {
        for(int i = 0; i < grid[])
    }
}