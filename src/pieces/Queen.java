package pieces;

import chessBase.Board;

/**
 * Created by isjo16 on 2018-09-29.
 */
public class Queen extends Piece {

    protected Queen(int x, int y, boolean player) {
        super(x, y, player);
        this.disp = (player) ? "\u2655" : "\u265B";
    }

    @Override
    public void checkMoves(Board board) {

    }
}
