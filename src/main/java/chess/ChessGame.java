package chess;

import chess.board.Board;
import chess.pieces.Piece;

import java.util.ArrayDeque;
import java.util.Deque;

public class ChessGame {
    public Board board;
    public Deque<Move> moves = new ArrayDeque<>();

    public ChessGame(){
        CheckDetector.setGame(this);
        board = new Board();
    }

    //returns true if the desired move is legal
    public void move(Piece piece, int newRow, int newColumn){

        Piece atePiece = board.getPieceAt(newRow, newColumn);
        int originalRow = piece.row;
        int originalCol = piece.column;

        board.setPieceAt(piece.row, piece.column, null);
        board.setPieceAt(newRow, newColumn, piece);

        Move move = new Move(piece, atePiece, originalRow, originalCol, newRow, newColumn);
        moves.addLast(move);
    }

    //dont need to check for legality here -> if it was moved, it was legal
    public void undoMove(Move move){
        //remove piece from its current location
        board.setPieceAt(move.movedRow, move.movedCol, move.movedPiece);

        //move it back into its old location
        board.setPieceAt(move.originalRow, move.originalCol, move.movedPiece);

        //if they ate a piece, return it to it's rightful place
        //if they didnt (movedPiece == null) then set the piece to empty
        board.setPieceAt(move.movedRow, move.movedCol, move.atePiece);
    }

    public void undoLastMove(){
        Move move = moves.removeLast();
        undoMove(move);
    }
}