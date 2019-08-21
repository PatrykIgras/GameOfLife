package models;

import enums.CellStatus;

public class Cell {
    private int cooX;
    private int cooY;
    private CellStatus cellStatus;

    public Cell(int cooX, int cooY, CellStatus cellStatus) {
        this.cooX = cooX;
        this.cooY = cooY;
        this.cellStatus = cellStatus;
    }

    public int getCooX() {
        return cooX;
    }

    public int getCooY() {
        return cooY;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }
}
