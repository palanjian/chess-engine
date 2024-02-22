package chess.pieces;

import chess.board.Board;
import chess.board.BoardColors;

public class King extends Piece{

    public King(BoardColors color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        //if there exists a white piece there, not legal
        if(board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == this.pieceColor) return false;

        return false;
    }
}