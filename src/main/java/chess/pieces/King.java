package chess.pieces;

import chess.CheckDetector;
import chess.board.Board;
import chess.board.BoardColor;

public class King extends Piece{

    public King(BoardColor color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        //if there exists a white piece there, not legal
        if(board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == this.pieceColor) return false;

        if(Math.abs(newRow-row) <= 1 && Math.abs(newColumn-column) <= 1)
            return CheckDetector.isKingSafe(board, this, newRow, newColumn);

        return false;
    }
}