package chess.pieces;

import chess.CheckDetector;
import chess.board.Board;
import chess.board.BoardColor;

public class Pawn extends Piece{

    public Pawn(BoardColor color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        boolean legal = false;
        //for white
        if(pieceColor== BoardColor.WHITE){
            //one forward
            if(column==newColumn && newRow == row-1 && board.pieces[newRow][newColumn] == null) legal = true;
            //two forward
            if(column==newColumn && row == 6 && newRow == 4 && board.pieces[newRow][newColumn] == null && board.pieces[5][column] == null) legal = true;
            //eat diagonal (left)
            if(column != 0 && newColumn==column-1 && newRow == row-1 && board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == BoardColor.BLACK) legal = true;
            //eat diagonal (right)
            if(column != 7 && newColumn==column+1 && newRow == row-1 && board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == BoardColor.BLACK) legal = true;
        }
        //for black
        else{
            //one forward
            if(column==newColumn && newRow == row+1 && board.pieces[newRow][newColumn] == null) legal = true;
            //two forward
            if(column==newColumn && row == 1 && newRow == 3 && board.pieces[newRow][newColumn] == null && board.pieces[2][column] == null) legal = true;
            //eat diagonal (left)
            if(column != 0 && newColumn==column-1 && newRow == row+1 && board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == BoardColor.WHITE) legal = true;
            //eat diagonal (right)
            if(column != 7 && newColumn==column+1 && newRow == row+1 && board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == BoardColor.WHITE) legal = true;

        }
        return legal && CheckDetector.isKingSafe(board, this, newRow, newColumn);
    }
}