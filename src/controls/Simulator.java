package controls;

import enums.CellStatus;
import models.Board;
import models.Cell;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private Board board;

    public Simulator(Board board) {
        this.board = board;
    }

    public void setLivingCell(int cooX, int cooy) {
        List<Cell> workList = board.getCellList();
        System.out.println();
        for (Cell cell : workList) {
            if (cell.getCooX() == cooX && cell.getCooY() == cooy) {
                cell.setCellStatus(CellStatus.C1);
            }
        }
    }

    public void simulateCell() {
        List<Cell> cellList = board.getCellList();
        List<Cell> cellList2 = new ArrayList<>();

        for (Cell cell : cellList) {
            int cellCooX = cell.getCooX();
            int cellCooY = cell.getCooY();
            int numberOfNeighbors = checkLivingNeighbor(cellCooX, cellCooY);
            if (cell.getCellStatus() == CellStatus.C0) {
                if (numberOfNeighbors == 3) {
                    Cell cell2 = new Cell(cellCooX, cellCooY, CellStatus.C1);
                    cellList2.add(cell2);
                } else {
                    cellList2.add(cell);
                }
            } else if (cell.getCellStatus() == CellStatus.C1) {
                if (numberOfNeighbors == 2 || numberOfNeighbors == 3) {
                    cellList2.add(cell);
                } else if (numberOfNeighbors > 3 || numberOfNeighbors < 2) {
                    Cell cell2 = new Cell(cellCooX, cellCooY, CellStatus.C0);
                    cellList2.add(cell2);
                }
            }
        }
        board.setList(cellList2);
    }

    public int checkLivingNeighbor(int x, int y) {

        int numberOfNeighbors = 0;
        if (x - 1 > -1 && y - 1 > -1 && board.getCell(x - 1, y - 1).getCellStatus() == CellStatus.C1) {
            numberOfNeighbors += 1;
        }
        if (y - 1 > -1 && board.getCell(x, y - 1).getCellStatus() == CellStatus.C1) {
            numberOfNeighbors += 1;
        }
        if (x + 1 < board.getBoardLines() && y - 1 > -1 && board.getCell(x + 1, y - 1).getCellStatus() == CellStatus.C1) {
            numberOfNeighbors += 1;
        }
        if (x + 1 < board.getBoardLines() && board.getCell(x + 1, y).getCellStatus() == CellStatus.C1) {
            numberOfNeighbors += 1;
        }
        if (x + 1 < board.getBoardLines() && y + 1 < board.getBoardColumns() && board.getCell(x + 1, y + 1).getCellStatus() == CellStatus.C1) {
            numberOfNeighbors += 1;
        }
        if (y + 1 < board.getBoardColumns() && board.getCell(x, y + 1).getCellStatus() == CellStatus.C1) {
            numberOfNeighbors += 1;
        }
        if (x - 1 > -1 && y + 1 < board.getBoardColumns() && board.getCell(x - 1, y + 1).getCellStatus() == CellStatus.C1) {
            numberOfNeighbors += 1;
        }
        if (x - 1 > -1 && board.getCell(x - 1, y).getCellStatus() == CellStatus.C1) {
            numberOfNeighbors += 1;
        }

        return numberOfNeighbors;
    }
}
