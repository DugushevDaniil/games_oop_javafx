package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {
    @Test
    public void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C3);
    }

    @Test
    public void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        assertThat(bishopBlack.copy(Cell.B2).position()).isEqualTo(Cell.B2);
    }

    @Test
    public void wayTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        Cell[] way = new Cell[] {Cell.D4, Cell.E5, Cell.F6, Cell.G7};
        assertThat(bishopBlack.way(Cell.G7)).isEqualTo(way);
    }

    @Test
    public void wayExceptionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> {
            bishopBlack.way(Cell.C2);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C3 to C2");
    }
}