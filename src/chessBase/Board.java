package chessBase;

import chessHelp.Move;
import pieces.King;
import pieces.Piece;

import java.awt.*;

/**
 * Created by isjo16 on 2018-09-28.
 */
public class Board {
    private Piece[] pieces = new Piece[64];
    private int width;
    private int height;
    private Display display; // not in UML

    Board(int w, int h, Display display){
        width = w;
        height = h;
        this.display = display;
    }

    public boolean atemptMove(Piece p, int x, int y){
        if(p.getMove(x, y) != null && p.getMove(x, y).valid){
            int ox = p.getX();
            int oy = p.getY();
            pieces[y * 8 + x] = p;
            pieces[oy * 8 + ox] = null;
            p.move(p.getMove(x, y));

            for(Piece c: pieces){
                if(c == null) continue;
                c.checkMoves(this);
            }
            return true;
        }
        return false;
    }

    public boolean checkCheck(Piece p, boolean player){
        for(Move m:p.getMoves()) {
            if (m.check && p.isPlayer() != player) {
                return true;
            }
        }
        return false;
    }
    public void drawBoard(Graphics2D g){
        g.setColor(new Color(247, 203, 91));
        for(int x = 0; x < display.getWidth(); x += width){
            g.setColor((g.getColor().equals(new Color(61, 56, 44)))? new Color(247, 203, 91) : new Color(61, 56, 44));
            for(int y = 0; y < display.getHeight(); y += height){
                g.setColor((g.getColor().equals(new Color(61, 56, 44)))? new Color(247, 203, 91) : new Color(61, 56, 44));
                g.fillRect(x, y, width, height);
            }
        }
        for(Piece p: pieces){
            if(p == null) continue;
            if(p.isPlayer()) g.setColor(Color.WHITE);
            else g.setColor(Color.black);
            if(p.isHighlighted()) g.setColor(Color.CYAN);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            Font font = new Font("Serif", Font.PLAIN, 96);
            g.setFont(font);
            g.drawString(p.disp, (p.getX() * width) + width/2 - g.getFontMetrics().stringWidth(p.disp)/2,
                    (p.getY() * height)  + ((height - g.getFontMetrics().getHeight()) / 2) + g.getFontMetrics().getAscent());
            //g.fillRect(p.getX() * width + 10, p.getY() * height + 10, 80, 80);
            //g.drawImage(p.getImg(), p.getX(),  p.getY(), (p.isPlayer())? Color.white : Color.black ,display);
        }
    }
    public Piece getPiece(int x, int y){
        Piece p = null;

        for(Piece pi: pieces){
            if(pi == null)continue;
            if(pi.isAt(x, y)){
                p = pi;
            }
        }

        return p;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void drawMoves(Piece p, Graphics2D g) {
        for(Move m: p.getMoves()){
            if(!m.valid) continue;
            if(m.valid) g.setColor(Color.GREEN);
            if(m.offensive) g.setColor(Color.RED);
            if(m.check) g.setColor(Color.blue);

            g.fillRect(m.getX() * width, m.getY() * width, width, height);
            g.setColor(Color.BLACK);
            g.drawRect(m.getX() * width, m.getY() * width, width, height);
        }
    }
}
