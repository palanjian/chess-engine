package chess.pieces;

import chess.board.Board;
import chess.board.BoardColors;

public class Knight extends Piece{

    public Knight(BoardColors color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        //if there exists a white piece there, not legal
        if(board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == this.pieceColor) return false;

        if(newRow == row + 2 && newColumn == column + 1) return true;
        if(newRow == row + 2 && newColumn == column - 1) return true;
        if(newRow == row - 2 && newColumn == column + 1) return true;
        if(newRow == row - 2 && newColumn == column - 1) return true;

        if(newRow == row + 1 && newColumn == column + 2) return true;
        if(newRow == row + 1 && newColumn == column - 2) return true;
        if(newRow == row - 1 && newColumn == column + 2) return true;
        if(newRow == row - 1 && newColumn == column - 2) return true;
        return false;
    }
}