package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX;
        int deltaY;
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        if (dest.getX() - position.getX() > 0) {
            deltaX = 1;
        } else {
            deltaX = -1;
        }
        if (dest.getY() - position.getY() > 0) {
            deltaY = 1;
        } else {
            deltaY = -1;
        }
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x + deltaX * (index + 1), y + deltaY * (index + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        int deltaX = Math.abs(source.getX() - dest.getX());
        int deltaY = Math.abs(source.getY() - dest.getY());
        if (deltaX == deltaY) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
