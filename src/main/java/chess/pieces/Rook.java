package chess.pieces;

import chess.board.Board;
import chess.board.BoardColors;

public class Rook extends Piece{

    public Rook(BoardColors color, int row, int column) {
        super(color, row, column);
    }

    public boolean isLegalMove(Board board, int newRow, int newColumn) {
        //if there exists a white piece there, not legal
        if(board.pieces[newRow][newColumn] != null && board.pieces[newRow][newColumn].pieceColor == this.pieceColor) return false;

        //if its moving side to slide
        if(newRow == row && newColumn < column){
            for(int i=newColumn+1; i<column; ++i){
                if(board.pieces[row][i] != null) return false;
            }
            return true;
        }
        else if(newRow == row && newColumn > column){
            for(int i=newColumn-1; i>column; --i){
                if(board.pieces[row][i] != null) return false;
            }
            return true;
        }

        //if moving up and down
        else if(newColumn == column && newRow < row){
            for(int i=newRow+1; i<row; ++i){
                if(board.pieces[i][column] != null) return false;
            }
            return true;
        }
        else if(newColumn == column && newRow > row){
            for(int i=newRow-1; i>row; --i){
                if(board.pieces[i][column] != null) return false;
            }
            return true;
        }
        return false;
    }
}