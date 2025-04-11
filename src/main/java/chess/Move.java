package chess;

import chess.pieces.Piece;

public class Move {
    Piece movedPiece;
    Piece atePiece;
    int originalRow;
    int originalCol;
    int movedRow;
    int movedCol;

    public Move(Piece movedPiece, Piece atePiece, int originalRow, int originalCol, int movedRow, int movedCol){
        this.movedPiece = movedPiece;
        this.atePiece = atePiece;
        this.originalRow = originalRow;
        this.originalCol = originalCol;
        this.movedRow = movedRow;
        this.movedCol = movedCol;
    }
}
