package visualization;

import chess.board.Board;
import chess.pieces.Piece;

public class Debugger {
    public static void printAllLegalMoves(GamePanel gp){
        Debugger.clearDebug(gp);
        Board board = gp.game.board;
        for(Piece piece : board.allPieces){
            for(int i=0; i<8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (piece.isLegalMove(board, i, j)) {
                        gp.debugBoard[i][j] = true;
                    }
                }
            }
        }
        gp.repaint();
    }

    public static void printLegalMoves(GamePanel gp, int row, int column){
        Debugger.clearDebug(gp);
        Board board = gp.game.board;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if(board.pieces[row][column] != null && board.pieces[row][column].isLegalMove(board, i, j)){
                    gp.debugBoard[i][j] = true;
                }
            }
        }
        gp.repaint();
    }

    public static void clearDebug(GamePanel gp) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                gp.debugBoard[i][j] = false;
            }
        }
    }
}
