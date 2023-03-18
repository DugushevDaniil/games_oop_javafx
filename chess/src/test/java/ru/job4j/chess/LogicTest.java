package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.add(new BishopBlack(Cell.C8));
            logic.add(new PawnBlack(Cell.E6));
            logic.move(Cell.C8, Cell.G4);
        });
        assertThat(exception.getMessage()).isEqualTo("The path to the cell is blocked by another figure");
    }

    @Test
    public void ImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
        logic.add(new BishopBlack(Cell.C3));
        logic.move(Cell.C3, Cell.G8);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C3 to G8");
    }
}