package chess.board;

import chess.pieces.*;

import java.util.HashSet;
import java.util.Set;

public class Board {
    public Piece[][] pieces;
    public Set<Piece> allPieces;
    public BoardColors[][] colors;

    public Board(){
        pieces = new Piece[8][8];
        allPieces = new HashSet<>();
        colors = new BoardColors[8][8];

        //initializes board colors
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if(i%2 == 0 && j%2==0 || i%2 == 1 && j%2==1) colors[i][j] = BoardColors.WHITE;
                else colors[i][j] = BoardColors.BLACK;
            }
        }

        //initializes pawn locations
        for(int j=0; j<8; ++j){
            Piece blackPawn = new Pawn(BoardColors.BLACK, 1, j);
            Piece whitePawn = new Pawn(BoardColors.WHITE, 6, j);
            pieces[1][j] = blackPawn;
            pieces[6][j] = whitePawn;
            allPieces.add(blackPawn);
            allPieces.add(whitePawn);
        }

        //initializes rest of pieces
        Piece blackRook1 = new Rook(BoardColors.BLACK, 0, 0);
        Piece blackRook2 = new Rook(BoardColors.BLACK, 0, 7);
        Piece whiteRook1 = new Rook(BoardColors.WHITE, 7, 0);
        Piece whiteRook2 = new Rook(BoardColors.WHITE, 7, 7);
        pieces[0][0] = blackRook1; pieces[0][7] = blackRook2;
        pieces[7][0] = whiteRook1; pieces[7][7] = whiteRook2;
        allPieces.add(blackRook1); allPieces.add(blackRook2);
        allPieces.add(whiteRook1); allPieces.add(whiteRook2);

        //knights
        Piece blackKnight1 = new Knight(BoardColors.BLACK, 0, 1);
        Piece blackKnight2 = new Knight(BoardColors.BLACK, 0, 6);
        Piece whiteKnight1 = new Knight(BoardColors.WHITE, 7, 1);
        Piece whiteKnight2 = new Knight(BoardColors.WHITE, 7, 6);
        pieces[0][1] = blackKnight1; pieces[0][6] = blackKnight2;
        pieces[7][1] = whiteKnight1; pieces[7][6] = whiteKnight2;
        allPieces.add(blackKnight1); allPieces.add(blackKnight2);
        allPieces.add(whiteKnight1); allPieces.add(whiteKnight2);

        Piece blackBishop1 = new Bishop(BoardColors.BLACK, 0, 2);
        Piece blackBishop2 = new Bishop(BoardColors.BLACK, 0, 5);
        Piece whiteBishop1 = new Bishop(BoardColors.WHITE, 7, 2);
        Piece whiteBishop2 = new Bishop(BoardColors.WHITE, 7, 5);
        pieces[0][2] = blackBishop1; pieces[0][5] = blackBishop2;
        pieces[7][2] = whiteBishop1; pieces[7][5] = whiteBishop2;
        allPieces.add(blackBishop1); allPieces.add(blackBishop2);
        allPieces.add(whiteBishop1); allPieces.add(whiteBishop2);


        Piece blackKing = new King(BoardColors.BLACK, 0, 4);
        Piece whiteKing = new King(BoardColors.WHITE, 7, 4);
        Piece blackQueen = new Queen(BoardColors.BLACK, 0, 3);
        Piece whiteQueen = new Queen(BoardColors.WHITE, 7, 3);
        pieces[0][4] = blackKing; pieces[0][3] = blackQueen;
        pieces[7][4] = whiteKing; pieces[7][3] = whiteQueen;
        allPieces.add(blackKing); allPieces.add(blackQueen);
        allPieces.add(whiteKing); allPieces.add(whiteQueen);

        System.out.println(allPieces.size());
    }
}
