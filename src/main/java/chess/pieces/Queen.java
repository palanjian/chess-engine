package chess.pieces;

import chess.CheckDetector;
import chess.board.Board;
import chess.board.BoardColor;

public class Queen extends Piece{

    public Queen(BoardColor color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        //if there exists a white piece there, not legal
        if(board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == this.pieceColor) return false;

        //if moving like bishop
        if(Math.abs(newRow-row) == Math.abs(newColumn-column)){
            int colOffset = newColumn > column ? 1 : -1;
            int rowOffset = newRow > row ? 1 : -1;

            for(int i=1; i<Math.abs(newRow-row); ++i){
                if(board.pieces[row+(i*rowOffset)][column+(i*colOffset)] != null) return false;
            }
            return CheckDetector.isKingSafe(board, this, newRow, newColumn);
        }
        //if moving like rook
        if(newRow == row || newColumn == column){
            //if its moving side to slide
            if(newRow == row){
                int start = Math.min(column, newColumn);
                for(int i=1; i<Math.abs(newColumn-column); ++i){
                    if(board.pieces[row][start+i] != null) return false;
                }
                return CheckDetector.isKingSafe(board, this, newRow, newColumn);
            }
            //if moving up and down
            else{
                int start = Math.min(row, newRow);
                for(int i=1; i<Math.abs(newRow-row); ++i){
                    if(board.pieces[start+i][column] != null) return false;
                }
                return CheckDetector.isKingSafe(board, this, newRow, newColumn);
            }
        }
        return false;
    }
}