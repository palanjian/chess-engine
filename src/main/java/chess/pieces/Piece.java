package chess.pieces;

import chess.board.BoardColors;

public abstract class Piece {
    public BoardColors pieceColor = null;
    public Piece(BoardColors color){
        this.pieceColor = color;
    }
}
