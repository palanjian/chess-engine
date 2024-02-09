package main;

import chess.ChessGame;
import visualization.Visualizer;

public class Main {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        Visualizer visualizer = new Visualizer(game);

        visualizer.visualize();
    }
}