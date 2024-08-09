package chess.pieces;

import chess.CheckDetector;
import chess.board.Board;
import chess.board.BoardColor;

public class Bishop extends Piece{

    public Bishop(BoardColor color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        //if there exists a white piece there, not legal
        if(board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == this.pieceColor) return false;
        if(Math.abs(newRow-row) != Math.abs(newColumn-column)) return false;

        int colOffset = newColumn > column ? 1 : -1;
        int rowOffset = newRow > row ? 1 : -1;

        for(int i=1; i<Math.abs(newRow-row); ++i){
            if(board.pieces[row+(i*rowOffset)][column+(i*colOffset)] != null) return false;
        }
        return CheckDetector.isKingSafe(board, this, newRow, newColumn);
    }
}