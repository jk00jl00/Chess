package chessBase;

import pieces.Pawn;
import pieces.Piece;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by isjo16 on 2018-09-28.
 */
public class Controller implements Runnable{

    private Piece highlightedPiece;
    private Display display;
    private Board board;
    private boolean playerTurn = true;
    private boolean running;
    private MouseListener ml;
    private Thread thread;
    private int width;
    private int height;


    public Controller(){
        this.display = new Display();
        height = display.getHeight() / 8;
        width = display.getWidth() / 8;
        this.ml = new MouseListener();
        this.display.addMouseListener(this.ml);
        this.board = new Board(height, height, display);
    }

    public synchronized void start(){
        if(!this.running) {
            this.running = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    public synchronized void stop(){
        if(this.running){
            this.running = false;
            try {
                this.thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        int fps = 60;
        double timePerFrame = 1000000000/fps;
        long start;
        long now;
        double dt = 0;
        start = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        //pawns
        for(int x = 0; x<8; x++) {
            board.getPieces()[6 * 8 + x] = new Pawn(x, 6, true);
            board.getPieces()[1 * 8 + x] = new Pawn(x, 1, false);
        }
        for(Piece p: board.getPieces()){
            if(p == null) continue;
            p.checkMoves(board);
        }

        //GameLoop
        while (running){
            now = System.nanoTime();
            dt += (now - start)/ timePerFrame;
            timer += now - start;
            start = now;
            if (dt >= 1) {
                tick();
                draw();
                dt --;
                ticks++;
            }
            if(timer >= 250000000){
                ticks = 0;
                timer = 0;
            }
        }
    }

    private void tick(){
        if(ml.hasLClick()){
            handleLClick();
        }
        if(ml.hasRClick()){
            handleRClick();
        }
    }

    private void draw(){
        BufferStrategy bs = display.getBufferStrategy();
        if(bs == null){
            display.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        //Start of drawing

        board.drawBoard(g);
        if(highlightedPiece != null){
            board.drawMoves(highlightedPiece, g);
        }

        //End of Drawing

        bs.show();
        g.dispose();
    }

    private void handleLClick(){
        ml.noLClick();
        int x = ml.getX() / (display.getWidth() / 8);
        int y = ml.getY() / (display.getHeight() / 8);

        System.out.println(x);
        System.out.println(y);

        if (highlightedPiece == null) {
            Piece p = null;

            p = board.getPiece(x, y);

            if(p == null || playerTurn != p.isPlayer()){
                return;
            }
            p.setHighlighted(true);
            highlightedPiece = p;
            return;
        } else{
            handleMove(x, y);
        }
    }

    private void handleRClick(){
        ml.noRClick();
        if(highlightedPiece == null) return;
        highlightedPiece.setHighlighted(false);
        highlightedPiece = null;
    }

    private void handleMove(int x, int y){
        if(board.atemptMove(highlightedPiece, x, y)){
            highlightedPiece.setHighlighted(false);
            highlightedPiece = null;
            playerTurn = !playerTurn;
        }
    }

    private void handleWin(){

    }

    private boolean checkWin(){
        return false;
    }

    private void checkWindow(){

    }
}
