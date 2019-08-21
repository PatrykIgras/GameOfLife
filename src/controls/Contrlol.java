package controls;

import enums.CellStatus;
import models.Board;
import models.Cell;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Contrlol {
    private Board board = new Board();
    private Cell cell;
    private Scanner scan = new Scanner(System.in);
    private Simulator simulator = new Simulator(board);

    public void fillStartBoard(int numberOfLine, int numberOfColumn) {
        board.setBoardLines(numberOfLine);
        board.setBoardColumns(numberOfColumn);

        for (int x = 0; x < numberOfLine; x++) {
            for (int y = 0; y < numberOfColumn; y++) {
                cell = new Cell(x, y, CellStatus.C0);
                board.addToCellList(cell);
            }
        }
    }

    public void chooseCellsToLive() {
        System.out.println("Ile komórek chcesz ożywić");
        int numberOfCells = scan.nextInt();
        for (int i = 0; i < numberOfCells; i++) {
            System.out.println("Podaj współrzędne X komórki");
            int x = scan.nextInt();
            System.out.println("Podaj współrzędne Y komórki");
            int y = scan.nextInt();

            simulator.setLivingCell(x, y);
        }
    }

    public void setRandomCellsToLive() {
        List<Cell> workList = board.getCellList();
        Random random = new Random();

        for (Cell cell : workList) {
            int randInt = random.nextInt(2);
            if (randInt == 0)
                cell.setCellStatus(CellStatus.C0);
            if (randInt == 1)
                cell.setCellStatus(CellStatus.C1);
        }
    }

    public void setCrocodile() {
        simulator.setLivingCell(8, 20);
        simulator.setLivingCell(9, 20);
        simulator.setLivingCell(10, 20);
        simulator.setLivingCell(8, 21);
        simulator.setLivingCell(10, 21);
        simulator.setLivingCell(8, 22);
        simulator.setLivingCell(9, 22);
        simulator.setLivingCell(10, 22);
        simulator.setLivingCell(8, 23);
        simulator.setLivingCell(9, 23);
        simulator.setLivingCell(10, 23);
        simulator.setLivingCell(8, 24);
        simulator.setLivingCell(9, 24);
        simulator.setLivingCell(10, 24);
        simulator.setLivingCell(8, 25);
        simulator.setLivingCell(9, 25);
        simulator.setLivingCell(10, 25);
        simulator.setLivingCell(8, 26);
        simulator.setLivingCell(10, 26);
        simulator.setLivingCell(8, 27);
        simulator.setLivingCell(9, 27);
        simulator.setLivingCell(10, 27);
    }

    public void setLineShape() {
        simulator.setLivingCell(0, 1);
        simulator.setLivingCell(1, 1);
        simulator.setLivingCell(2, 1);
    }

    public void choseNumberOfSteps() {
        System.out.println("Wybierz liczbe kroków");
        int numberOfSteps = scan.nextInt();
        for (int i = 0; i < numberOfSteps; i++) {
            simulator.simulateCell();
            printBoard();
            printInterSpace();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printBoard() {
        board.printBoard();
    }

    public void printInterSpace() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

    public Board getBoard() {
        return board;
    }
}
