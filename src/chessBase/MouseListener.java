package chessBase;

import java.awt.event.MouseEvent;

/**
 * Created by isjo16 on 2018-09-28.
 */
public class MouseListener implements java.awt.event.MouseListener {
    private boolean lClick;
    private boolean rClick;
    private int x;
    private int y;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        if(e.getButton() == MouseEvent.BUTTON1) lClick = true;
        if(e.getButton() == MouseEvent.BUTTON3) rClick = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasLClick(){
        return lClick;
    }
    public boolean hasRClick(){
        return rClick;
    }

    public void noLClick() {
        this.lClick = false;
    }
    public void noRClick() {
        this.rClick = false;
    }
}
