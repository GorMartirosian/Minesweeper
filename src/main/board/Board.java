package main.board;

import main.board.cell.Cell;
import java.util.ArrayList;

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
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
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

    private void validate(int row, int col) {
        if((row >= height || row < 0) || (col >= width || col < 0)) {
            throw new IllegalArgumentException("Invalid value range for row or column!");
        }
    }

    public void openCell(int row, int col) {
        validate(row,col);
        switch(cellAt(row, col).open()) {
            case BOMB_FOUND -> gameOver();
            case PERFORMED_OPENING -> {
                if(bombsNearby(row,col) == 0) {
                    openAdjacentCells(row,col);
                }
            }
        }
    }

    private void openAdjacentCells(int row, int col) {
        for (Coordinate neighbor : neighboringCellCoordinates(row, col)) {
            openCell(neighbor.getX(),neighbor.getY());
        }
    }

    private ArrayList<Coordinate> neighboringCellCoordinates(int row, int col) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                int currentCellRow = row + i;
                int currentCellCol = col + j;
                boolean currentIsInternalCell = currentCellRow >= 0 && currentCellCol >= 0
                        && currentCellRow < height && currentCellCol < width;
                if(currentIsInternalCell) {
                    coordinates.add(new Coordinate(currentCellRow,currentCellCol));
                }
            }
        }
        return coordinates;
    }

    private void gameOver(){
        System.out.println("The Game Is Over!");
        revealBoard();
    }

    public void markCell(int row, int col, boolean mark) {
        validate(row,col);
        cellAt(row,col).setMark(mark);
    }

    public void revealBoard(){

    }

    private boolean checkWin() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                Cell currentCell = cellAt(i,j);
                if(currentCell.isOpened() || currentCell.hasBomb()) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    private int bombsNearby(int row, int col) {
        validate(row,col);
        int bombCount = 0;
        for(Coordinate coordinate : neighboringCellCoordinates(row,col)) {
            if(cellAt(coordinate.getX(),coordinate.getY()).hasBomb()){
                bombCount++;
            }
        }
        return bombCount;
    }

    private void print() {
        System.out.print("  ");
        for (int i = 0; i < width; i++) {
            System.out.print(i + " ");
        }
        for(int i = 0; i < height; i++) {
            System.out.print(i + " ");
            printRow(i);
        }
    }

    private void printRow(int row) {
        //💣|⬜|🏁 --- emojis for cells
        System.out.print("|");
        for(int i = 0; i < width; i++) {
            Cell currentCell = cellAt(row,i);
            if(!currentCell.isOpened()) {
                if (currentCell.isMarked()){
                    System.out.print("\uD83C\uDFC1");
                } else {
                    System.out.print("⬜");
                }
            }else {
                if(currentCell.hasBomb()){
                    System.out.print("\uD83D\uDCA3");
                }else {
                    System.out.print(bombsNearby(row, i));
                }
            }
            System.out.print("|");
        }
        System.out.println();
    }

    private Cell cellAt(int row, int col){
        validate(row, col);
        return grid[row][col];
    }
}