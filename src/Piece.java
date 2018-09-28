import java.awt.*;
import java.util.ArrayList;

/**
 * Created by isjo16 on 2018-09-28.
 */
public abstract class Piece {
    private int x;
    private int y;
    private ArrayList<Move> moves = new ArrayList<>();
    boolean highlighted;
    boolean player; //not in UML
    Image img;

    Piece(int x, int y, boolean highlighted){
        this.x = x;
        this.y = y;
        this.highlighted = highlighted;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public abstract Move getMove(int x, int y);

    public abstract void move(Move move);

    protected abstract void checkMoves();

    public boolean isAt(int x, int y){
        return (this.x == x && this.y == y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
