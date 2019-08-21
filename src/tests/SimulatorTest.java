package tests;

import controls.Contrlol;
import controls.Simulator;
import enums.CellStatus;
import models.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {

    @Test
    void shouldCountNumberOfNeighbors(){
        Contrlol contrlol = new Contrlol();
        Board board = contrlol.getBoard();
        Simulator simulator = new Simulator(board);
        contrlol.fillStartBoard(10, 10);
        contrlol.setLineShape();

        assertAll(
                () -> assertEquals(3, simulator.checkLivingNeighbor(1, 0)),
                () -> assertEquals(2, simulator.checkLivingNeighbor(0, 0)),
                () -> assertEquals(2, simulator.checkLivingNeighbor(2, 0)),
                () -> assertEquals(1, simulator.checkLivingNeighbor(0, 1)),
                () -> assertEquals(2, simulator.checkLivingNeighbor(1, 1)),
                () -> assertEquals(3, simulator.checkLivingNeighbor(1, 2)),
                () -> assertEquals(2, simulator.checkLivingNeighbor(2, 2))
        );
    }

    @Test
    void shouldUncorrectCountNumberOfNeighbors(){
        Contrlol contrlol = new Contrlol();
        Board board = contrlol.getBoard();
        Simulator simulator = new Simulator(board);
        contrlol.fillStartBoard(10, 10);
        contrlol.setLineShape();

        assertAll(
                () -> assertNotEquals(0, simulator.checkLivingNeighbor(1, 0)),
                () -> assertNotEquals(-1, simulator.checkLivingNeighbor(0, 0)),
                () -> assertNotEquals(5, simulator.checkLivingNeighbor(2, 0)),
                () -> assertNotEquals(2, simulator.checkLivingNeighbor(0, 1)),
                () -> assertNotEquals(1, simulator.checkLivingNeighbor(1, 1)),
                () -> assertNotEquals(2, simulator.checkLivingNeighbor(1, 2)),
                () -> assertNotEquals(3, simulator.checkLivingNeighbor(2, 2))
        );
    }

    @Test
    void shouldSimulateTheLivingCell(){
        Contrlol contrlol = new Contrlol();
        Board board = contrlol.getBoard();
        Simulator simulator = new Simulator(board);
        contrlol.fillStartBoard(10, 10);
        contrlol.setLineShape();
        simulator.simulateCell();

        assertAll(
                () -> assertEquals(CellStatus.C0, contrlol.getBoard().getCell(0, 0).getCellStatus()),
                () -> assertEquals(CellStatus.C0, contrlol.getBoard().getCell(0, 1).getCellStatus()),
                () -> assertEquals(CellStatus.C0, contrlol.getBoard().getCell(0, 2).getCellStatus()),
                () -> assertEquals(CellStatus.C0, contrlol.getBoard().getCell(2, 0).getCellStatus()),
                () -> assertEquals(CellStatus.C0, contrlol.getBoard().getCell(2, 1).getCellStatus()),
                () -> assertEquals(CellStatus.C0, contrlol.getBoard().getCell(2, 2).getCellStatus()),
                () -> assertEquals(CellStatus.C1, contrlol.getBoard().getCell(1, 0).getCellStatus()),
                () -> assertEquals(CellStatus.C1, contrlol.getBoard().getCell(1, 1).getCellStatus()),
                () -> assertEquals(CellStatus.C1, contrlol.getBoard().getCell(1, 2).getCellStatus())
        );
    }

    @Test
    void shouldUncorrectSimulateTheLivingCell(){
        Contrlol contrlol = new Contrlol();
        Board board = contrlol.getBoard();
        Simulator simulator = new Simulator(board);
        contrlol.fillStartBoard(10, 10);
        contrlol.setLineShape();
        simulator.simulateCell();

        assertAll(
                () -> assertNotEquals(CellStatus.C1, contrlol.getBoard().getCell(0, 0).getCellStatus()),
                () -> assertNotEquals(CellStatus.C1, contrlol.getBoard().getCell(0, 1).getCellStatus()),
                () -> assertNotEquals(CellStatus.C1, contrlol.getBoard().getCell(0, 2).getCellStatus()),
                () -> assertNotEquals(CellStatus.C1, contrlol.getBoard().getCell(2, 0).getCellStatus()),
                () -> assertNotEquals(CellStatus.C1, contrlol.getBoard().getCell(2, 1).getCellStatus()),
                () -> assertNotEquals(CellStatus.C1, contrlol.getBoard().getCell(2, 2).getCellStatus()),
                () -> assertNotEquals(CellStatus.C0, contrlol.getBoard().getCell(1, 0).getCellStatus()),
                () -> assertNotEquals(CellStatus.C0, contrlol.getBoard().getCell(1, 1).getCellStatus()),
                () -> assertNotEquals(CellStatus.C0, contrlol.getBoard().getCell(1, 2).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(0, 0).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(0, 1).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(0, 2).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(2, 0).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(2, 1).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(2, 2).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(1, 0).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(1, 1).getCellStatus()),
                () -> assertNotEquals(null, contrlol.getBoard().getCell(1, 2).getCellStatus())
        );
    }
    @Test
    void shouldSetTheNewLivingCell(){
        Contrlol contrlol = new Contrlol();
        Board board = contrlol.getBoard();
        Simulator simulator = new Simulator(board);
        contrlol.fillStartBoard(10, 10);
        simulator.setLivingCell(0, 0);

        assertEquals(CellStatus.C1, contrlol.getBoard().getCell(0, 0).getCellStatus());
    }


    @Test
    void shouldNotSetTheNewLivingCell(){
        Contrlol contrlol = new Contrlol();
        Board board = contrlol.getBoard();
        Simulator simulator = new Simulator(board);
        contrlol.fillStartBoard(10, 10);
        simulator.setLivingCell(0, 0);

        assertNotEquals(CellStatus.C0, contrlol.getBoard().getCell(0, 0).getCellStatus());
        assertNotEquals(null, contrlol.getBoard().getCell(0, 0).getCellStatus());
    }

}