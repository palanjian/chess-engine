package chess.pieces;

import chess.board.Board;
import chess.board.BoardColors;

public abstract class Piece {
    public BoardColors pieceColor;
    public int row;
    public int column;

    public Piece(BoardColors color, int row, int column){
        this.pieceColor = color;
        this.row = row;
        this.column = column;
    }

    public abstract boolean isLegalMove(Board board, int row, int column);
}
