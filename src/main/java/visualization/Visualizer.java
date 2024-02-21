package visualization;

import chess.ChessGame;

import javax.swing.*;

public class Visualizer {
    ChessGame game;
    public static JFrame window;
    public GamePanel gp;
    public CommandHandler ch;


    public Visualizer(ChessGame game){
        this.game = game;
        this.gp = new GamePanel(game);
        setupVisuals();
        setupCommandHandler();
        setGamePanel(gp);
    }

    public void setupVisuals(){
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("я люблю шахматы <3");
    }

    public void setGamePanel(GamePanel gp) {
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
    }

    public void visualize(){
        window.setVisible(true);
        gp.repaint();
    }

    public void setupCommandHandler(){
        ch = new CommandHandler(gp);
        ch.start();
    }
}
