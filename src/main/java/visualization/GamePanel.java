package visualization;

import chess.ChessGame;
import chess.board.Board;
import chess.board.BoardColors;
import chess.pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    private final int tileSize = 64;
    private final int borderSize = 16;
    BufferedImage[] pieceSprites;
    ChessGame game;

    boolean[][] debugBoard = new boolean[8][8];
    public Piece selectedPiece = null;

    public GamePanel(ChessGame game){
        this.game = game;
        this.setPreferredSize(new Dimension(tileSize * 8, tileSize*8));
        this.setBackground(Color.GREEN);
        this.setFocusable(true);
        pieceSprites = GraphicsUtil.getSpriteArray(GraphicsUtil.loadImage("chess_sprites.png"), 2, 6, tileSize);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { onClicked(e); };
        });
    }

    public void onClicked(MouseEvent e){
        int row = e.getY() / tileSize;
        int column = e.getX() / tileSize;

        Piece piece = game.board.pieces[row][column];

        if(selectedPiece == null){
            selectedPiece = piece;
            Debugger.printLegalMoves(this, row, column);
        }
        //if piece has been selected, just deselect it
        else if(row == selectedPiece.row && column == selectedPiece.column){
            Debugger.clearDebug(this);
            selectedPiece = null;
            repaint();
        }
        else if(debugBoard[row][column]){
            move(selectedPiece, row, column);
        }
    }

    public void move(Piece piece, int newRow, int newColumn){
        Debugger.clearDebug(this);
        game.board.pieces[piece.row][piece.column] = null;
        piece.row = newRow;
        piece.column = newColumn;

        game.board.pieces[newRow][newColumn] = piece;

        selectedPiece = null;

        repaint();
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        drawBoard(g2);
        drawPieces(g2);
        g2.dispose();
    }

    public void drawBoard(Graphics2D g2){
        Board board = game.board;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if(debugBoard[i][j]) g2.setColor(Color.RED);
                else if(board.colors[i][j] == BoardColors.WHITE) g2.setColor(Color.WHITE);

                else g2.setColor(Color.DARK_GRAY);

                g2.fillRect((j * tileSize), (i * tileSize), tileSize, tileSize);
            }
        }
    }

    public void drawPieces(Graphics2D g2) {
        Board board = game.board;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                Piece piece = board.pieces[i][j];
                int spriteNumber = 0;
                if(piece != null) {
                    if (piece.getClass().equals(Pawn.class)) spriteNumber = 5;
                    //else if (piece.getClass().equals(King.class)) spriteNumber = 0;
                    //else if (piece.getClass().equals(Queen.class)) spriteNumber = 1;
                    //else if (piece.getClass().equals(Bishop.class)) spriteNumber = 2;
                    //else if (piece.getClass().equals(Knight.class)) spriteNumber = 3;
                    else if (piece.getClass().equals(Rook.class)) spriteNumber = 4;

                    if(piece.pieceColor == BoardColors.BLACK) spriteNumber += 6;


                    g2.drawImage(pieceSprites[spriteNumber], j * tileSize + (borderSize/2), i * tileSize + (borderSize/2), tileSize - borderSize, tileSize - borderSize, null);
                }
            }
        }
    }
}
