package chess;

import chess.board.Board;
import chess.board.BoardColor;
import chess.pieces.*;

public class CheckDetector {
    public static boolean isKingSafe(Board board, Piece piece, int newRow, int newCol){
        BoardColor color = piece.pieceColor;
        Piece king = (color == BoardColor.WHITE) ? board.kings[0] : board.kings[1];

        board.move(piece, newRow, newCol);
        boolean isChecked = isKingInCheck(board, king);
        board.undoLastMove();

        return !isChecked;
    }

    public static boolean isKingInCheck(Board board, Piece king){

        //linear search, should be changed in the future
        //TODO: change to targeted search (horizontals, diagonals, horse moves, pawn moves)
        //TODO AFTER: look into BitBoards

        if(attackedByPawn(board, king)) return true;
        if(attackedByBishop(board, king)) return true;
        if(attackedByRook(board, king)) return true;
        if(attackedByKnight(board, king)) return true;

        return false;
    }

    public static boolean attackedByPawn(Board board, Piece king){
        int row = king.row;
        int col = king.column;
        if(king.pieceColor == BoardColor.WHITE){
            if(isInBounds(row-1, col+1) && board.pieces[row-1][col+1] != null && board.pieces[row-1][col+1].getClass() == Pawn.class && board.pieces[row-1][col+1].pieceColor != king.pieceColor) return true;
            if(isInBounds(row-1, col-1) && board.pieces[row-1][col-1] != null && board.pieces[row-1][col-1].getClass() == Pawn.class && board.pieces[row-1][col-1].pieceColor != king.pieceColor) return true;
        }
        else{
            if(isInBounds(row+1, col+1) && board.pieces[row+1][col+1] != null && board.pieces[row+1][col+1].getClass() == Pawn.class  && board.pieces[row+1][col+1].pieceColor != king.pieceColor) return true;
            if(isInBounds(row+1, col-1) && board.pieces[row+1][col-1] != null && board.pieces[row+1][col-1].getClass() == Pawn.class && board.pieces[row+1][col-1].pieceColor != king.pieceColor) return true;
        }
        return false;
    }

    public static boolean attackedByKnight(Board board, Piece king){
        int row = king.row;
        int col = king.column;
        if(existsEnemyKnight(board, king, row+2, col+1)) return true;
        if(existsEnemyKnight(board, king, row+2, col-1)) return true;
        if(existsEnemyKnight(board, king, row-2, col+1)) return true;
        if(existsEnemyKnight(board, king, row-2, col-1)) return true;
        if(existsEnemyKnight(board, king, row+1, col+2)) return true;
        if(existsEnemyKnight(board, king, row+1, col-2)) return true;
        if(existsEnemyKnight(board, king, row-1, col+2)) return true;
        if(existsEnemyKnight(board, king, row-1, col-2)) return true;
        return false;
    }

    private static boolean existsEnemyKnight(Board board, Piece king, int row, int col) {
        if(!isInBounds(row, col)) return false;
        Piece pieceAtLoc = board.pieces[row][col];
        if(pieceAtLoc != null && pieceAtLoc.pieceColor != king.pieceColor && pieceAtLoc.getClass() == Knight.class)
            return true;
        return false;
    }

    public static boolean attackedByBishop(Board board, Piece king) {
        return isAttackedOnDiagonal(board, king, 1, 1) ||
                isAttackedOnDiagonal(board, king, 1, -1) ||
                isAttackedOnDiagonal(board, king, -1, 1) ||
                isAttackedOnDiagonal(board, king, -1, -1);
    }

    public static boolean attackedByRook(Board board, Piece king){
        return isAttackedOnHorizontal(board, king, true, 1) ||
                isAttackedOnHorizontal(board, king, true, -1) ||
                isAttackedOnHorizontal(board, king, false, 1) ||
                isAttackedOnHorizontal(board, king, false, -1);
    }
    private static boolean isAttackedOnDiagonal(Board board, Piece king, int rowOffset, int colOffset) {
        int row = king.row;
        int column = king.column;

        for (int i = 1; i < 8; i++) {
            int newRow = row + (i * rowOffset);
            int newCol = column + (i * colOffset);

            if (!isInBounds(newRow, newCol)) break;

            Piece piece = board.pieces[newRow][newCol];
            if (piece != null) {
                if ((piece.getClass() == Queen.class || piece.getClass() == Bishop.class) && piece.pieceColor != king.pieceColor) return true;
                break;
            }
        }
        return false;
    }

    private static boolean isAttackedOnHorizontal(Board board, Piece king, boolean checkRow, int offset) {
        int row = king.row;
        int col = king.column;
        for(int i=1; i<8; ++i){
            int newRow = checkRow ? row : row + (i*offset);
            int newCol = !checkRow ? col : col + (i*offset);

            if (!isInBounds(newRow, newCol)) break;
            Piece piece = board.pieces[newRow][newCol];
            if (piece != null) {
                if ((piece.getClass() == Queen.class || piece.getClass() == Rook.class) && piece.pieceColor != king.pieceColor) return true;
                break;
            }
        }
        return false;
    }
    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
