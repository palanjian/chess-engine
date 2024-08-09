package chess.pieces;

import chess.CheckDetector;
import chess.board.Board;
import chess.board.BoardColor;

public class Knight extends Piece{

    public Knight(BoardColor color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        //if there exists a white piece there, not legal
        if(board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == this.pieceColor) return false;

        boolean legal = false;
        if(newRow == row + 2 && newColumn == column + 1) legal = true;
        else if(newRow == row + 2 && newColumn == column - 1) legal = true;
        else if(newRow == row - 2 && newColumn == column + 1) legal = true;
        else if(newRow == row - 2 && newColumn == column - 1) legal = true;

        else if(newRow == row + 1 && newColumn == column + 2) legal = true;
        else if(newRow == row + 1 && newColumn == column - 2) legal = true;
        else if(newRow == row - 1 && newColumn == column + 2) legal = true;
        else if(newRow == row - 1 && newColumn == column - 2) legal = true;
        return legal && CheckDetector.isKingSafe(board, this, newRow, newColumn);
    }
}