import java.awt.*;
import java.awt.image.BufferedImageOp;

/**
 * Created by isjo16 on 2018-09-28.
 */
public class Board {
    private Piece[] pieces;
    private int width;
    private int height;
    private Display display; // not in UML

    Board(int w, int h, Display display){
        width = w;
        height = h;
        this.display = display;
    }

    public boolean atemptMove(Piece p, int x, int y){
        if(p.getMove(x, y) != null && p.getMove(x, y).valid ){
            p.move(p.getMove(x, y));
            return true;
        }
        return false;
    }

    public boolean checkCheck(Piece p){
        for(Move m:p.getMoves()) {
            if (m.check) {
                return true;
            }
        }
        return false;
    }
    public void drawBoard(Graphics2D g){
        for(Piece p: pieces){
            g.drawImage(p.img, p.getX(),  p.getY(), (p.player)? Color.white : Color.black ,display);
        }
    }
    public Piece getPiece(int x, int y){
        Piece p = null;

        for(Piece pi: pieces){
            if(pi.isAt(x, y)){
                p = pi;
            }
        }

        return p;
    }
}
