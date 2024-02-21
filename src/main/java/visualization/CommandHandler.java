package visualization;

import chess.ChessGame;
import chess.board.Board;
import chess.board.BoardColors;
import chess.pieces.Piece;

import java.awt.*;
import java.util.Scanner;

public class CommandHandler extends Thread {

    public GamePanel gp;
    public CommandHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        while(true){
            String command = scan.nextLine().strip();
            String args[] = command.split(" ");
            if(args[0].equals("plm")){
                Debugger.printLegalMoves(gp, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            }
            if(args[0].equals("palm")){
                Debugger.printAllLegalMoves(gp);
            }
        }
    }
}
