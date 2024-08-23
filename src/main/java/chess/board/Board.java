package chess.board;

import chess.pieces.*;

import java.util.HashSet;
import java.util.Set;

public class Board {
    public Piece[][] pieces;
    public Set<Piece> allPieces;
    public BoardColor[][] colors;

    //white king is index 0, black king index 1
    public Piece[] kings;


    ///TEMMPPP
    ///JUST FOR NOW

    Piece lastMovedPiece;
    Piece atePiece;
    int originalRow;
    int originalCol;
    int movedRow;
    int movedCol;
    ////
    ////

    public Board(){
        pieces = new Piece[8][8];
        allPieces = new HashSet<>();
        colors = new BoardColor[8][8];
        kings = new King[2];
        initalizePieces();
    }

    public void move(Piece piece, int newRow, int newColumn){
        //TEMPPP
        //FIX LATER
        lastMovedPiece = piece;
        atePiece = pieces[newRow][newColumn];
        originalRow = piece.row;
        originalCol = piece.column;
        movedRow = newRow;
        movedCol = newColumn;
        /////
        ////

        pieces[piece.row][piece.column] = null;
        piece.row = newRow;
        piece.column = newColumn;
        pieces[newRow][newColumn] = piece;
    }
    public void undoLastMove(){
        pieces[movedRow][movedCol] = atePiece;
        pieces[originalRow][originalCol] = lastMovedPiece;
        lastMovedPiece.row = originalRow;
        lastMovedPiece.column = originalCol;
    }

    public void initalizePieces(){
        //initializes board colors
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if(i%2 == 0 && j%2==0 || i%2 == 1 && j%2==1) colors[i][j] = BoardColor.WHITE;
                else colors[i][j] = BoardColor.BLACK;
            }
        }

        //initializes pawn locations
        for(int j=0; j<8; ++j){
            Piece blackPawn = new Pawn(BoardColor.BLACK, 1, j);
            Piece whitePawn = new Pawn(BoardColor.WHITE, 6, j);
            pieces[1][j] = blackPawn;
            pieces[6][j] = whitePawn;
            allPieces.add(blackPawn);
            allPieces.add(whitePawn);
        }

        //initializes rest of pieces
        Piece blackRook1 = new Rook(BoardColor.BLACK, 0, 0);
        Piece blackRook2 = new Rook(BoardColor.BLACK, 0, 7);
        Piece whiteRook1 = new Rook(BoardColor.WHITE, 7, 0);
        Piece whiteRook2 = new Rook(BoardColor.WHITE, 7, 7);
        pieces[0][0] = blackRook1; pieces[0][7] = blackRook2;
        pieces[7][0] = whiteRook1; pieces[7][7] = whiteRook2;
        allPieces.add(blackRook1); allPieces.add(blackRook2);
        allPieces.add(whiteRook1); allPieces.add(whiteRook2);

        //knights
        Piece blackKnight1 = new Knight(BoardColor.BLACK, 0, 1);
        Piece blackKnight2 = new Knight(BoardColor.BLACK, 0, 6);
        Piece whiteKnight1 = new Knight(BoardColor.WHITE, 7, 1);
        Piece whiteKnight2 = new Knight(BoardColor.WHITE, 7, 6);
        pieces[0][1] = blackKnight1; pieces[0][6] = blackKnight2;
        pieces[7][1] = whiteKnight1; pieces[7][6] = whiteKnight2;
        allPieces.add(blackKnight1); allPieces.add(blackKnight2);
        allPieces.add(whiteKnight1); allPieces.add(whiteKnight2);

        Piece blackBishop1 = new Bishop(BoardColor.BLACK, 0, 2);
        Piece blackBishop2 = new Bishop(BoardColor.BLACK, 0, 5);
        Piece whiteBishop1 = new Bishop(BoardColor.WHITE, 7, 2);
        Piece whiteBishop2 = new Bishop(BoardColor.WHITE, 7, 5);
        pieces[0][2] = blackBishop1; pieces[0][5] = blackBishop2;
        pieces[7][2] = whiteBishop1; pieces[7][5] = whiteBishop2;
        allPieces.add(blackBishop1); allPieces.add(blackBishop2);
        allPieces.add(whiteBishop1); allPieces.add(whiteBishop2);


        Piece blackKing = new King(BoardColor.BLACK, 0, 4);
        Piece whiteKing = new King(BoardColor.WHITE, 7, 4);
        Piece blackQueen = new Queen(BoardColor.BLACK, 0, 3);
        Piece whiteQueen = new Queen(BoardColor.WHITE, 7, 3);
        pieces[0][4] = blackKing; pieces[0][3] = blackQueen;
        pieces[7][4] = whiteKing; pieces[7][3] = whiteQueen;
        allPieces.add(blackKing); allPieces.add(blackQueen);
        allPieces.add(whiteKing); allPieces.add(whiteQueen);

        kings[0] = whiteKing;
        kings[1] = blackKing;
    }
}
