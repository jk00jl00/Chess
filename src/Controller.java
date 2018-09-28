/**
 * Created by isjo16 on 2018-09-28.
 */
public class Controller {

    private Piece highlightedPiece;
    private Display display;
    private Board board;
    private boolean playerTurn;
    private boolean running;
    private MouseListener ml;
    private Thread thread;
    private int width;
    private int height;


    Controller(){
        this.display = new Display();
        this.ml = new MouseListener();
        this.display.addMouseListener(this.ml);
        this.board = new Board(height, height);
    }
}
