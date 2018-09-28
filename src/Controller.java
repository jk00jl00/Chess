/**
 * Created by isjo16 on 2018-09-28.
 */
public class Controller implements Runnable{

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

    }

    private void tick(){

    }

    private void draw(){

    }

    private void handleLClick(){

    }

    private void handleRClick(){

    }

    private void handleMove(){

    }

    private void handleWin(){

    }

    private boolean checkWin(){
        return false;
    }

    private void checkWindow(){

    }
}
