package models;

import enums.CellStatus;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cellList = new ArrayList<>();
    private int boardLines = 0;
    private int boardColumns = 0;

    public List<Cell> getCellList() {
        return cellList;
    }

    public void addToCellList(Cell cell) {
        this.cellList.add(cell);
    }

    public int getBoardLines() {
        return boardLines;
    }

    public void setBoardLines(int boardLines) {
        this.boardLines = boardLines;
    }

    public int getBoardColumns() {
        return boardColumns;
    }

    public void setBoardColumns(int boardColumns) {
        this.boardColumns = boardColumns;
    }

    public void printBoard(){
        for (int x = 0; x < boardLines; x++){
            for (int y = 0; y < boardColumns; y++){
                CellStatus cell = null;
                for (Cell oneCell : cellList){
                    if (oneCell.getCooX() == x && oneCell.getCooY() == y){
                            cell = oneCell.getCellStatus();
                    }
                }
                System.out.print(cell.getCellStat());
            }
            System.out.println();
        }
    }

    public Cell getCell(int x, int y){
        Cell celllll = null;
        for(Cell c : cellList){
            if (c.getCooX() == x && c.getCooY() == y){
                celllll = c;
            }
        }
        return celllll;
    }

    public void setList(List<Cell> cellList2) {
        this.cellList = cellList2;
    }
}
