package visualization;

import chess.board.Board;

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
                clearDebug();
                setRed(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                gp.repaint();
            }
        }
    }
    public void setRed(int row, int column){
        Board board = gp.game.board;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if(board.pieces[row][column] != null && board.pieces[row][column].isLegalMove(board, i, j)){
                    gp.debugBoard[i][j] = true;
                }
            }
        }
    }
    public void clearDebug(){
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                gp.debugBoard[i][j] = false;
            }
        }
    }
}
