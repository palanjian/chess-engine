package chess.pieces;

import chess.board.Board;
import chess.board.BoardColor;

public abstract class Piece {
    public BoardColor pieceColor;
    public int row;
    public int column;

    public Piece(BoardColor color, int row, int column){
        this.pieceColor = color;
        this.row = row;
        this.column = column;
    }

    public abstract boolean isLegalMove(Board board, int row, int column);
}
