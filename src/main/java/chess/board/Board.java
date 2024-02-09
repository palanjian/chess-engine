package chess.board;

import chess.pieces.*;

public class Board {
    public Piece[][] pieces;
    public BoardColors[][] colors;

    public Board(){
        pieces = new Piece[8][8];
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
            Piece blackPawn = new Pawn(BoardColors.BLACK);
            Piece whitePawn = new Pawn(BoardColors.WHITE);
            pieces[1][j] = blackPawn;
            pieces[6][j] = whitePawn;
        }

        //initializes rest of pieces
        pieces[0][0] = new Rook(BoardColors.BLACK); pieces[0][7] = new Rook(BoardColors.BLACK);
        pieces[0][1] = new Knight(BoardColors.BLACK); pieces[0][6] = new Knight(BoardColors.BLACK);
        pieces[0][2] = new Bishop(BoardColors.BLACK); pieces[0][5] = new Bishop(BoardColors.BLACK);
        pieces[0][4] = new King(BoardColors.BLACK); pieces[0][3] = new Queen(BoardColors.BLACK);

        pieces[7][0] = new Rook(BoardColors.WHITE); pieces[7][7] = new Rook(BoardColors.WHITE);
        pieces[7][1] = new Knight(BoardColors.WHITE); pieces[7][6] = new Knight(BoardColors.WHITE);
        pieces[7][2] = new Bishop(BoardColors.WHITE); pieces[7][5] = new Bishop(BoardColors.WHITE);
        pieces[7][4] = new King(BoardColors.WHITE); pieces[7][3] = new Queen(BoardColors.WHITE);
    }
}
