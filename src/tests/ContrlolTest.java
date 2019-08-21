package tests;

import controls.Contrlol;
import enums.CellStatus;
import models.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContrlolTest {

    @Test
    void shouldFillTheBoard() {
        Contrlol contrlol = new Contrlol();
        contrlol.fillStartBoard(10, 10);

        assertEquals(100, contrlol.getBoard().getCellList().size());
    }


    @Test
    void shouldFillTheBoardWithTheWrongNumberOfCells() {
        Contrlol contrlol = new Contrlol();
        contrlol.fillStartBoard(10, 10);

        assertAll(
                () -> assertNotEquals(101, contrlol.getBoard().getCellList().size()),
                () -> assertNotEquals(199, contrlol.getBoard().getCellList().size()),
                () -> assertNotEquals(0, contrlol.getBoard().getCellList().size()),
                () -> assertNotEquals(-1, contrlol.getBoard().getCellList().size())
        );
    }

    @Test
    void theFilledBoardShouldHaveDefoultCellsType() {
        Contrlol contrlol = new Contrlol();
        contrlol.fillStartBoard(10, 10);

        for (Cell cell : contrlol.getBoard().getCellList()) {
            assertEquals(CellStatus.C0, cell.getCellStatus());
        }
    }


}