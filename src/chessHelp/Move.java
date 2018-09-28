package chessHelp;

/**
 * Created by isjo16 on 2018-09-28.
 */
public class Move {
    int x;
    int y;
    public boolean valid;
    public boolean offensive;
    public boolean check;

    public Move(int x, int y, boolean valid, boolean offensive, boolean check){
        this.x = x;
        this.y = y;
        this.valid = valid;
        this.check = check;
        this.offensive = offensive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
