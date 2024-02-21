package chess.pieces;

import chess.board.Board;
import chess.board.BoardColors;

public class Pawn extends Piece{

    public Pawn(BoardColors color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        //for white
        if(pieceColor==BoardColors.WHITE){
            //one forward
            if(column==newColumn && newRow == row-1 && board.pieces[newRow][newColumn] == null) return true;
            //two forward
            if(column==newColumn && row == 6 && newRow == 4 && board.pieces[newRow][newColumn] == null && board.pieces[5][column] == null) return true;
            //eat diagonal (left)
            if(column != 0 && newColumn==column-1 && newRow == row-1 && board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == BoardColors.BLACK) return true;
            //eat diagonal (right)
            if(column != 7 && newColumn==column+1 && newRow == row-1 && board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == BoardColors.BLACK) return true;
        }
        //for black
        else{
            //one forward
            if(column==newColumn && newRow == row+1 && board.pieces[newRow][newColumn] == null) return true;
            //two forward
            if(column==newColumn && row == 1 && newRow == 3 && board.pieces[newRow][newColumn] == null && board.pieces[2][column] == null) return true;
            //eat diagonal (left)
            if(column != 0 && newColumn==column-1 && newRow == row+1 && board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == BoardColors.WHITE) return true;
            //eat diagonal (right)
            if(column != 7 && newColumn==column+1 && newRow == row+1 && board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == BoardColors.WHITE) return true;

        }
        return false;
    }
}