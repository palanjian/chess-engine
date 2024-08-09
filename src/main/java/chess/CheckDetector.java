package chess;

import chess.board.Board;
import chess.board.BoardColor;
import chess.pieces.Piece;

public class CheckDetector {
    public static boolean isKingSafe(Board board, Piece piece, int newRow, int newCol){
        BoardColor color = piece.pieceColor;
        Piece king = (color == BoardColor.WHITE) ? board.kings[0] : board.kings[1];

        int originalRow = piece.row;
        int originalCol = piece.column;

    
        //return isChecked;
        return true;
    }

    public static boolean isKingInCheck(Board board, Piece king){

        //linear search, should be changed in the future
        //TODO: change to targeted search (horizontals, diagonals, horse moves, pawn moves)
        //TODO AFTER: look into BitBoards
        for(Piece piece : board.allPieces){
            if(piece.pieceColor != king.pieceColor && piece.isLegalMove(board, king.row, king.column)) return true;
        }

        return false;
    }

}
