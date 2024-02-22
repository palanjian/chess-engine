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
        pieces[0][0] = blackRook1; pieces[0][7] = blackRook2;
        allPieces.add(blackRook1); allPieces.add(blackRook2);
        //pieces[0][1] = new Knight(BoardColors.BLACK); pieces[0][6] = new Knight(BoardColors.BLACK);
        //pieces[0][2] = new Bishop(BoardColors.BLACK); pieces[0][5] = new Bishop(BoardColors.BLACK);
        //pieces[0][4] = new King(BoardColors.BLACK); pieces[0][3] = new Queen(BoardColors.BLACK);

        //pieces[7][0] = new Rook(BoardColors.WHITE); pieces[7][7] = new Rook(BoardColors.WHITE);
        //pieces[7][1] = new Knight(BoardColors.WHITE); pieces[7][6] = new Knight(BoardColors.WHITE);
        //pieces[7][2] = new Bishop(BoardColors.WHITE); pieces[7][5] = new Bishop(BoardColors.WHITE);
        //pieces[7][4] = new King(BoardColors.WHITE); pieces[7][3] = new Queen(BoardColors.WHITE);
    }
}
