package pieces;

import chessBase.Board;
import chessHelp.Move;

import java.util.ArrayList;

/**
 * Created by isjo16 on 2018-09-28.
 */
public class Pawn extends Piece {
    private boolean hasMoved = false;
    public Pawn(int x, int y, boolean player) {
        super(x, y, player);
        this.disp = (!player)? "\u2659" : "\u265F";
    }

    @Override
    public void checkMoves(Board board) {
        moves = new ArrayList<>();
        boolean blocked = false;
        int a = (player) ? -1 : 1;
        if((y > 0 && a < 0) || (y < 7 && a > 0)){
            for(int i = -1; i < 2; i++) {
                if(x + i < 8 && x - i >= 0) {
                    if (board.getPieces()[(y + a) * 8 + i + x] == null) {
                        if(i == 0)
                            moves.add(new Move(x + i, y + a, true, false, false));
                        else{
                            moves.add(new Move(x + i, y + a, false, true, false));
                        }
                    } else  {
                        if(i != 0)
                          moves.add(new Move(x + i, y + a, (board.getPieces()[(y + a) * 8 + i + x].isPlayer() != this.isPlayer()) , (board.getPieces()[(y + a) * 8 + i + x].isPlayer() != this.isPlayer()), board.getPieces()[(y + a) * 8 + i + x] instanceof  King));
                        else blocked = true;
                    }
                }
            }
            if(!blocked && !hasMoved){
                if (board.getPieces()[(y + (a * 2)) * 8  + x] == null) {
                    moves.add(new Move(x , y + a * 2, true, false, false));
                }

            }
        }
    }

    @Override
    public void move(Move move) {
        super.move(move);
        hasMoved = true;
    }
}
