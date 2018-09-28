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
    Image img;

    Piece(int x, int y, boolean highlighted, Image img){
        this.x = x;
        this.y = y;
        this.highlighted = highlighted;
        this.img = img;
    }
}
